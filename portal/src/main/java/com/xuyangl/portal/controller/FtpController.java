package com.xuyangl.portal.controller;

import com.xuyangl.portal.domain.Message;
import com.xuyangl.portal.domain.ResponseMessage;
import com.xuyangl.portal.service.FtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Description
 * @Author: liuXuyang
 * @studentNo 15130110024
 * @Emailaddress 1187697635@qq.com
 * @Date: 2018/7/6 11:07
 */
@RestController
public class FtpController {


    @Autowired
    private FtpService ftpService;

    @RequestMapping(value = "/file/upload",method = RequestMethod.POST)
    public ResponseMessage upload(MultipartFile multipartFile)
    {
        ftpService.uploadFile(multipartFile);
        return new ResponseMessage("成功",1);
    }
}
