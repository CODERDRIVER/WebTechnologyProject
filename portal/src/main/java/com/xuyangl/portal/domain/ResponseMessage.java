package com.xuyangl.portal.domain;

/**
 * @Description
 * @Author: liuXuyang
 * @studentNo 15130110024
 * @Emailaddress 1187697635@qq.com
 * @Date: 2018/6/27 11:00
 */
public class ResponseMessage {

    String msg;
    int code;

    String authorization;
    public ResponseMessage() {
    }

    public ResponseMessage(String msg, int code) {
        this.msg = msg;
        this.code = code;
    }

    public ResponseMessage(String msg, int code, String authorization) {
        this.msg = msg;
        this.code = code;
        this.authorization = authorization;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }


    public String getAuthorization() {
        return authorization;
    }

    public void setAuthorization(String authorization) {
        this.authorization = authorization;
    }
}
