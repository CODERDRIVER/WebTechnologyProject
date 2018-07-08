package com.xuyangl.portal.domain;

/**
 * @Description
 * @Author: liuXuyang
 * @studentNo 15130110024
 * @Emailaddress 1187697635@qq.com
 * @Date: 2018/7/6 10:31
 */
public class FtpRespnseMessage {

    private int status;

    private String url;

    private String message;


    public FtpRespnseMessage()
    {

    }
    public FtpRespnseMessage(int status,String url,String message)
    {
        this.status = status;
        this.url= url;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
