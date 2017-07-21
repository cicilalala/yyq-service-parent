package com.yyq.data.mongo.web;

import com.yyq.base.support.dto.Result;
import com.yyq.base.support.utils.ResultUtil;
import com.yyq.data.mongo.domain.MongoFile;
import com.yyq.data.mongo.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by yangyunqi on 2017/5/15.
 */
@Api(value = "files", description = "文件操作")
@RestController
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping("saveFile")
    @ApiOperation(value = "文件保存", httpMethod = "POST", response = Result.class, notes = "文件保存")
    public Result saveFile(@RequestParam("uploader") String uploader, @RequestParam("file")MultipartFile file) {
        String id = fileService.saveFile(uploader, file);
        return ResultUtil.success(id);
    }

    @GetMapping("searchAll")
    @ApiOperation(value = "得到文件列表", httpMethod = "GET", response = Result.class, notes = "得到文件列表")
    public Result searchAll() {
        List<MongoFile> fileVOList = fileService.searchAll();
        return ResultUtil.success(fileVOList);
    }

    @GetMapping("getFile")
    @ApiOperation(value = "文件下载", httpMethod = "GET", response = StreamingResponseBody.class, notes = "文件下载")
    public StreamingResponseBody getFile(@RequestParam("id") String id, HttpServletResponse response) {
        return fileService.getFile(id, response);
    }

    @GetMapping("deleteFile")
    @ApiOperation(value = "删除文件", httpMethod = "GET", response = Result.class, notes = "删除文件")
    public Result deleteFile(@RequestParam("id") String id) {
        fileService.deleteFile(id);
        return ResultUtil.success(id);
    }
}
