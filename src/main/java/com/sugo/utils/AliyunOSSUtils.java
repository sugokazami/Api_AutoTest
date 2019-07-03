package com.sugo.utils;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.CannedAccessControlList;
import com.aliyun.oss.model.CreateBucketRequest;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import com.sugo.constant.PropertiesConstant;
import lombok.extern.slf4j.Slf4j;

import java.io.File;

@Slf4j
public class AliyunOSSUtils {

    public static String upload(File file) {

        log.info("=========>OSS文件上传开始：" + file.getName());

        if (null == file) {
            return null;
        }

        OSSClient ossClient = new OSSClient(PropertiesConstant.END_POINT, PropertiesConstant.ACCESS_KEY, PropertiesConstant.SECRET_KEY);
        try {
            //容器不存在，就创建
            if (!ossClient.doesBucketExist(PropertiesConstant.BUCKET_NAME)) {
                ossClient.createBucket(PropertiesConstant.BUCKET_NAME);
                CreateBucketRequest createBucketRequest = new CreateBucketRequest(PropertiesConstant.BUCKET_NAME);
                createBucketRequest.setCannedACL(CannedAccessControlList.PublicRead);
                ossClient.createBucket(createBucketRequest);
            }

            //创建文件路径
            String fileUrl = PropertiesConstant.FILE_PATH + file.getName();
            //上传文件
            PutObjectResult result = ossClient.putObject(new PutObjectRequest(PropertiesConstant.BUCKET_NAME, fileUrl, file));
            //设置权限 这里是公开读
            ossClient.setBucketAcl(PropertiesConstant.BUCKET_NAME, CannedAccessControlList.PublicRead);

            String accessoryPath = "https://" + PropertiesConstant.BUCKET_NAME + "." + PropertiesConstant.END_POINT + "/" + fileUrl ;

            if (null != result) {
                log.info("==========>OSS文件上传成功,OSS地址：" + accessoryPath);
                return accessoryPath;
            }
        } catch (OSSException oe) {
            log.info("==========>OSS文件上传失败");
            log.error(oe.getMessage());
        } catch (ClientException ce) {
            log.info("==========>OSS文件上传失败");
            log.error(ce.getMessage());
        } finally {
            //关闭
            ossClient.shutdown();
        }
        return null;
    }
}
