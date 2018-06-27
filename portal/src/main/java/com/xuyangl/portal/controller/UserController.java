package com.xuyangl.portal.controller;

import com.xuyangl.portal.bean.User;
import com.xuyangl.portal.domain.Audience;
import com.xuyangl.portal.domain.ResponseMessage;
import com.xuyangl.portal.service.UserService;
import com.xuyangl.portal.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.jar.JarEntry;

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

    @Autowired
    private Audience audience;
    /**
     * 120.78.148.207:8080/user/login?username=lxy&password=lxy
     * code:1
     * msg:登陆成功
     *
     *  * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ResponseMessage login(String username, String password)
    {
        boolean login = userService.login(username, password);
        if (login)
        {
            //创建JWT
            //首先获取user的所有信息
            User user1 = new User();
            user1.setUsername(username);
            user1.setPassword(password);
            User user = userService.findUser(user1);
            String jwt = JwtUtil.createJWT(username,user.getId()+"","user"
                    ,audience.getClientId(),audience.getName(),audience.getExpiresSecond()*1000,audience.getBase64Secret());
            String resulturl = "bearer;"+jwt;
            return new ResponseMessage("登陆成功",1,resulturl);
        }else{
            return new ResponseMessage("用户名或者密码错误",0);
        }
    }

    /**
     * 注册页面
     * 120.78.148.207:8080/user/register
     */
    @RequestMapping(value="/register",method = RequestMethod.POST)
    public ResponseMessage register(User user)
    {
        //调用service 保存数据库
        boolean register = userService.register(user);
        if (register)
        {
            //保存成功
            return new ResponseMessage("注册成功",1);
        }else{
            return new ResponseMessage("注册失败",0);
        }
    }


}
