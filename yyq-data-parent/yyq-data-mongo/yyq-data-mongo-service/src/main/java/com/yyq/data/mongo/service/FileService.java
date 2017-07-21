package com.yyq.data.mongo.service;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;
import com.yyq.base.support.utils.StrUtil;
import com.yyq.data.mongo.domain.MongoFile;
import com.yyq.data.mongo.exception.FileException;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by yangyunqi on 2017/5/15.
 */
@Slf4j
@Service
public class FileService {

    // 文件存储的仓库名称
    private static final String FILES_REPOSITORY = "files-db";

    @Autowired
    private MongoTemplate mongoTemplate;

    public String saveFile(String uploader, MultipartFile file) {

        final Date uploaderDate = new Date();
        final String id = String.valueOf(uploaderDate.getTime());

        File tempFile = null;
        try {
            String tempFilePath = new ClassPathResource("/file").getFile().getAbsolutePath();
            String tempFileName = StrUtil.randomUUID();
            tempFile = new File(tempFilePath + "/" + tempFileName);

            // 将文件存储到服务器临时目录
            file.transferTo(tempFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        DB db = mongoTemplate.getDb();
        GridFS gridFS = new GridFS(db, FILES_REPOSITORY);
        try {
            if (tempFile != null && tempFile.isFile()) {
                GridFSInputFile gridFSInputFile = gridFS.createFile(tempFile);
                gridFSInputFile.put("_id", id);
                gridFSInputFile.put("filename", file.getOriginalFilename());
                gridFSInputFile.put("contentType", file.getContentType());
                gridFSInputFile.put("length", file.getSize());
                gridFSInputFile.put("uploader", uploader);
                gridFSInputFile.put("uploadDate", uploaderDate);

                // 将文件存储到Mongodb中
                gridFSInputFile.save();

                tempFile.delete();
            } else {
                throw new FileException(500, "Can Not Find Server Local File");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return id;
    }

    public StreamingResponseBody getFile(String id, HttpServletResponse response) {

        DB db = mongoTemplate.getDb();
        GridFS gridFS = new GridFS(db, FILES_REPOSITORY);
        BasicDBObject query = new BasicDBObject("_id", id);
        GridFSDBFile file = gridFS.findOne(query);

        InputStream inputStream;

        if (file != null) {

            String fileName = file.getFilename();
            Long fileSize = file.getLength();
            inputStream = file.getInputStream();

            response.setCharacterEncoding("UTF-8");
            response.setContentType("multipart/form-data");
            response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
            response.setHeader("Content-length", String.valueOf(fileSize));
        } else {
            throw new FileException(500, "Can Not Find Server Local File");
        }
        return outputStream -> IOUtils.copy(inputStream, outputStream);
    }

    public void deleteFile(String id) {
        DB db = mongoTemplate.getDb();
        GridFS gridFS = new GridFS(db, FILES_REPOSITORY);
        BasicDBObject query = new BasicDBObject("_id", id);
        GridFSDBFile file = gridFS.findOne(query);

        if (file != null) {
            gridFS.remove(query);
        } else {
            throw new FileException(500, "Can Not Find Server Local File");
        }
    }

    public List<MongoFile> searchAll() {

        DB db = mongoTemplate.getDb();
        GridFS gridFS = new GridFS(db, FILES_REPOSITORY);
        List<GridFSDBFile> fileList = gridFS.find(new BasicDBObject());
        List<MongoFile> mongoFileList = new ArrayList<>();
        if (!fileList.isEmpty()) {
            for (GridFSDBFile gridFSDBFile : fileList) {
                MongoFile mongoFile = new MongoFile();
                mongoFile.setId(String.valueOf(gridFSDBFile.getId()))
                        .setFileName(gridFSDBFile.getFilename())
                        .setFileType(gridFSDBFile.getContentType())
                        .setFileSize(gridFSDBFile.getLength())
                        .setUploader(String.valueOf(gridFSDBFile.get("uploader")))
                        .setUploadTime(gridFSDBFile.getUploadDate());
                mongoFileList.add(mongoFile);
            }
        }
        return mongoFileList;
    }
}
