package com.xuyangl.portal.service;

import com.xuyangl.portal.bean.User;

/**
 * @Description
 * @Author: liuXuyang
 * @studentNo 15130110024
 * @Emailaddress 1187697635@qq.com
 * @Date: 2018/6/25 17:33
 */
public interface UserService {
    public boolean login(String username,String password);
    public boolean register(User user);
    public User findUser(User user);    //根据部分信息找到该用户
}
