package com.xuyangl.portal.service.impl;

import com.xuyangl.portal.domain.FtpRespnseMessage;
import com.xuyangl.portal.service.FtpService;
import com.xuyangl.portal.util.FTPUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.net.ftp.FTPClient;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @Description
 * @Author: liuXuyang
 * @studentNo 15130110024
 * @Emailaddress 1187697635@qq.com
 * @Date: 2018/7/6 10:20
 */
@Service
public class FtpServiceImpl implements FtpService{


    @Value("${ftp.HOSTADDRESS}")
    private String HOSTADDRESS; //主机

    @Value("${ftp.PORT}")
    private int PORT; //端口

    @Value("${ftp.USERNAME}")
    private String USERNAME; //用户名

    @Value("${ftp.PASSWORD}")
    private String PASSWORD;    //密码

    @Value("${ftp.BASEPATH}")
    private String BASEPATH;    //基础文件夹路径

    @Override
    public FtpRespnseMessage uploadFile(MultipartFile multipartFile) {

        if (multipartFile==null||multipartFile.isEmpty())
        {
            //文件为空
            return new FtpRespnseMessage(0,null,"上传失败");
        }

        //获得文件的原有路径
        String originPath = multipartFile.getName();

        //获得文件后缀
        String ext = originPath.split("\\.")[1];


        //随机生成一个文件名称
        String fileName = UUID.randomUUID().toString();

        //对文件按日期进行分类
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");

         String dir =  simpleDateFormat.format(new Date());

        //组合文件名称
        String file = fileName+"."+ext;
        System.out.println(file);

        boolean b = FTPUtil.uploadFile(multipartFile, HOSTADDRESS, PORT, USERNAME, PASSWORD,BASEPATH, dir, file, FTPClient.ASCII_FILE_TYPE);
        System.out.println(b);
        if (b)
        {
            return new FtpRespnseMessage(1,"http://120.78.148.207:8080/"+BASEPATH+"/"+dir+"/"+file,null);

        }else{
            return new FtpRespnseMessage(0,null,"上传失败");

        }
    }

    @Override
    public FtpRespnseMessage uploadTemplate(String fileName, String content) {
        MultipartFile multipartFile = FTPUtil.changeFileToMul(fileName, content);
        FtpRespnseMessage ftpRespnseMessage = uploadFile(multipartFile);

        return ftpRespnseMessage;
    }
}
