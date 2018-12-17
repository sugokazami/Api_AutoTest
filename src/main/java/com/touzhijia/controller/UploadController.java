package com.touzhijia.controller;


import com.touzhijia.domain.Result;
import com.touzhijia.utils.ResultUtils;
import com.touzhijia.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public Result upload(MultipartFile file) {
        if (!file.isEmpty()) {
            String fileName = file.getOriginalFilename();
            if (StringUtils.isNotEmpty(fileName.trim())) {
                File newFile = new File(fileName);
                FileOutputStream out = null ;
                try {
                    out = new FileOutputStream(newFile);
                    out.write(file.getBytes());

                } catch (FileNotFoundException e) {
                    log.info("文件没有找到");
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    if (out != null){
                        try {
                            out.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return ResultUtils.success(file.getOriginalFilename());
    }
}
