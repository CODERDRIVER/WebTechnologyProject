package com.xuyangl.portal.controller;

import com.xuyangl.portal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author: liuXuyang
 * @studentNo 15130110024
 * @Emailaddress 1187697635@qq.com
 * @Date: 2018/5/28 14:22
 */
@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;
    /**
     * 120.78.148.207:8080/login?username=lxy&password=lxy
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(String username,String password)
    {
        boolean login = userService.login(username, password);
        if (login)
        {
            return "登录成功";
        }else{
            return "用户名或者密码错误";
        }
    }


}
