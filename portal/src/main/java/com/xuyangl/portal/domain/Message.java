package com.xuyangl.portal.domain;

/**
 * @Description
 * @Author: liuXuyang
 * @studentNo 15130110024
 * @Emailaddress 1187697635@qq.com
 * @Date: 2018/7/3 11:00
 */
public class Message {

    private int code; //状态码
    private String validation;  //验证码

    public Message(){

    }
    public Message(int code,String validation)
    {
        this.code = code;
        this.validation = validation;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getValidation() {
        return validation;
    }

    public void setValidation(String validation) {
        this.validation = validation;
    }
}
