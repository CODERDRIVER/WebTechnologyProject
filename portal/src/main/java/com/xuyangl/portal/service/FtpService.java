package com.xuyangl.portal.service;

import com.xuyangl.portal.domain.FtpRespnseMessage;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Description
 * @Author: liuXuyang
 * @studentNo 15130110024
 * @Emailaddress 1187697635@qq.com
 * @Date: 2018/7/6 10:19
 */
public interface FtpService {

    //上传文件
    public FtpRespnseMessage uploadFile(MultipartFile multipartFile);
}
