package com.xuyangl.portal.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * @Description websocket(广播式) 配置
 * @Author: liuXuyang
 * @studentNo 15130110024
 * @Emailaddress 1187697635@qq.com
 * @Date: 2018/5/23 14:16
 */


@Configuration
@SuppressWarnings("all")
@EnableWebSocketMessageBroker  //开启STOMP协议，之后的控制器支持MessageMapping
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer{



    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {

        //注册一个STOMP节点，并指定使用SockJS协议
        registry.addEndpoint("/endponitWisely").withSockJS();
    }

    /**
     * 配置消息代理
     * @param registry
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic");
    }
}
