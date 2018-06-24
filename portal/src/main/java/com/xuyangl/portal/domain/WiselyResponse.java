package com.xuyangl.portal.domain;

/**
 * @Description 相应的实体类
 * @Author: liuXuyang
 * @studentNo 15130110024
 * @Emailaddress 1187697635@qq.com
 * @Date: 2018/5/23 14:57
 */
public class WiselyResponse {
    String reponseName;
    String reponseMessage;

    public String getReponseName() {
        return reponseName;
    }

    public void setReponseName(String reponseName) {
        this.reponseName = reponseName;
    }

    public String getReponseMessage() {
        return reponseMessage;
    }

    public void setReponseMessage(String reponseMessage) {
        this.reponseMessage = reponseMessage;
    }

    public WiselyResponse(String reponseMessage,String responseName)
    {
        this.reponseName = responseName;
        this.reponseMessage = reponseMessage;
    }
}
