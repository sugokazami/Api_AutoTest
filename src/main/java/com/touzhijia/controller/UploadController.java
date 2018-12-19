package com.touzhijia.controller;


import com.touzhijia.constant.PropertiesConstant;
import com.touzhijia.domain.Result;
import com.touzhijia.utils.AliyunOSSUtils;
import com.touzhijia.utils.FileUtils;
import com.touzhijia.utils.ResultUtils;
import com.touzhijia.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

@RestController
@RequestMapping("/api")
@Slf4j
public class UploadController {

    @PostMapping("upload")
    public Result upload(@RequestParam("file") MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        File newFile = new File(FileUtils.getRootPath("static"),fileName);
        String accessoryPath = null ;
        if (!file.isEmpty()) {
            if (StringUtils.isNotEmpty(fileName.trim())) {
                file.transferTo(newFile);
                accessoryPath = AliyunOSSUtils.upload(newFile);
            }
        }
        return ResultUtils.success(accessoryPath);
    }
}
