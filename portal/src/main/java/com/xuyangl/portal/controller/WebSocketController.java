package com.xuyangl.portal.controller;

import com.xuyangl.portal.domain.WiselyMessage;
import com.xuyangl.portal.domain.WiselyResponse;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * @Description
 * @Author: liuXuyang
 * @studentNo 15130110024
 * @Emailaddress 1187697635@qq.com
 * @Date: 2018/5/23 14:58
 */
@Controller
public class WebSocketController {


    @MessageMapping("/welcome")     //浏览器通过该路径向服务器发送请求
    @SendTo("/topic/getReponse")    //会对所有订阅了topic/getResponse的浏览器发送信息
    public WiselyResponse reponse(WiselyMessage message) throws InterruptedException {
//        Thread.sleep(3000);
        return new WiselyResponse("welcome "+message.getName()+"!");
    }

}
