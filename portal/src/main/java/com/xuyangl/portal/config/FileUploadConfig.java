package com.xuyangl.portal.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.MultipartConfigElement;

/**
 * @Description 文件上传配置
 * @Author: liuXuyang
 * @studentNo 15130110024
 * @Emailaddress 1187697635@qq.com
 * @Date: 2018/7/6 11:33
 */

@Configuration
public class FileUploadConfig {


    @Bean
    public MultipartConfigElement multipartConfigElement(@Value("${multipart.maxFileSize}") String maxFileSize, @Value("${multipart.maxRequestSize}") String maxRequestFileSize)
    {
        MultipartConfigFactory factory = new MultipartConfigFactory();

        factory.setMaxFileSize(maxFileSize);

        factory.setMaxRequestSize(maxRequestFileSize);
        return factory.createMultipartConfig();
    }
}
