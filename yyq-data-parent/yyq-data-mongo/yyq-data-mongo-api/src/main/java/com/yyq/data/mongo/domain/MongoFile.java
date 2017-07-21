package com.yyq.data.mongo.domain;

import com.yyq.base.api.model.BaseModel;

import java.util.Date;

/**
 * Created by yangyunqi on 2017/7/21.
 */
public class MongoFile extends BaseModel<MongoFile> {

    private static final long serialVersionUID = 5273011137636154020L;
    private String id;
    private String fileName;
    private String fileType;
    private Long fileSize;
    private String uploader;
    private Date uploadTime;

    public MongoFile() {
    }

    public MongoFile(String id, String fileName, String fileType, Long fileSize, String uploader, Date uploadTime) {
        this.id = id;
        this.fileName = fileName;
        this.fileType = fileType;
        this.fileSize = fileSize;
        this.uploader = uploader;
        this.uploadTime = uploadTime;
    }

    public String getId() {
        return id;
    }

    public MongoFile setId(String id) {
        this.id = id;
        return this;
    }

    public String getFileName() {
        return fileName;
    }

    public MongoFile setFileName(String fileName) {
        this.fileName = fileName;
        return this;
    }

    public String getFileType() {
        return fileType;
    }

    public MongoFile setFileType(String fileType) {
        this.fileType = fileType;
        return this;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public MongoFile setFileSize(Long fileSize) {
        this.fileSize = fileSize;
        return this;
    }

    public String getUploader() {
        return uploader;
    }

    public MongoFile setUploader(String uploader) {
        this.uploader = uploader;
        return this;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public MongoFile setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
        return this;
    }
}
