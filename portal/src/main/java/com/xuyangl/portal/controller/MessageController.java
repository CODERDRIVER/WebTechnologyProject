package com.xuyangl.portal.controller;

import com.xuyangl.portal.domain.Message;
import com.xuyangl.portal.util.MessageUtil;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description  发送验证码的控制器
 * @Author: liuXuyang
 * @studentNo 15130110024
 * @Emailaddress 1187697635@qq.com
 * @Date: 2018/7/3 10:55
 */
@RestController
@RequestMapping("/message")
public class MessageController {


    /**
     * 接受手机号，发送验证码
     * @param phoneNum
     * @return
     * 1 表示正常发送
     * 0 表示发送失败
     */
    @RequestMapping(value = "/{phoneNum}",method = RequestMethod.GET)
    public Message sendCode(@PathVariable("phoneNum") String phoneNum)
    {
        String signName = "刘旭阳";
        String templateCode = "SMS_136090013";
        String s = MessageUtil.sendMessage(signName, templateCode, phoneNum);
        if (s!=null)
        {
            return new Message(1,s);
        }else{
            return new Message(0,"");
        }
    }

}
