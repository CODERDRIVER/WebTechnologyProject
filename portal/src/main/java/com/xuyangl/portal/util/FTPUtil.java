package com.xuyangl.portal.util;

import org.apache.commons.net.ftp.FTPClient;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

/**
 * @Description 文件上传工具类
 * @Author: liuXuyang
 * @studentNo 15130110024
 * @Emailaddress 1187697635@qq.com
 * @Date: 2018/7/6 10:13
 */
public class FTPUtil {


    /**
     *
     * @param multipartFile
     * @param addresss
     * @param port
     * @param username
     * @param password
     * @param dir
     * @param name
     * @param fileType
     * @return
     */
    public static boolean uploadFile(MultipartFile multipartFile,String addresss,int port,String username,String password,String bastPath,String dir,String name,int fileType)
    {
        //连接服务器
        FTPClient ftpClient = new FTPClient();
        InputStream fileInputStream = null;
        boolean flag = false;
        try{
            ftpClient.connect(addresss,port);
            fileInputStream = multipartFile.getInputStream();
            ftpClient.login(username,password);

            boolean b = ftpClient.changeWorkingDirectory(bastPath);
            String[] strings = dir.split("/");
            for (String s:strings)
            {
                ftpClient.makeDirectory(s);
                ftpClient.changeWorkingDirectory(s);
            }
            ftpClient.setFileType(fileType);
            flag = ftpClient.storeFile(name,fileInputStream);
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }
}
