package com.xuyangl.portal.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author: liuXuyang
 * @studentNo 15130110024
 * @Emailaddress 1187697635@qq.com
 * @Date: 2018/6/28 00:41
 */
@RestController
public class ManagerController {

    @RequestMapping(value = "/manager",method = RequestMethod.GET)
    public String managerPage()
    {
        return "manager.html";
    }
}
