package com.xuyangl.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Description
 * @Author: liuXuyang
 * @studentNo 15130110024
 * @Emailaddress 1187697635@qq.com
 * @Date: 2018/5/28 14:22
 */
@Controller
@RequestMapping("/")
public class LoginController {


    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(String username,String password)
    {
        return "login";
    }

}
