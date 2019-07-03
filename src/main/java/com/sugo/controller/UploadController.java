package com.sugo.controller;


import com.sugo.domain.Result;
import com.sugo.utils.AliyunOSSUtils;
import com.sugo.utils.FileUtils;
import com.sugo.utils.ResultUtils;
import com.sugo.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/api")
@Slf4j
public class UploadController {

    @CrossOrigin
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
