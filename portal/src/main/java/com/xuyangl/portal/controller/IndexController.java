package com.xuyangl.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Description
 * @Author: liuXuyang
 * @studentNo 15130110024
 * @Emailaddress 1187697635@qq.com
 * @Date: 2018/5/24 08:38
 */

@Controller
public class IndexController {

    //返回首页
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index()
    {
        return "index";
    }
}
