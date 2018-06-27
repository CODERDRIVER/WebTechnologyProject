package com.xuyangl.portal.service.impl;

import com.xuyangl.portal.dao.UserDao;
import com.xuyangl.portal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author: liuXuyang
 * @studentNo 15130110024
 * @Emailaddress 1187697635@qq.com
 * @Date: 2018/6/25 17:33
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public boolean login(String username, String password) {
        String passwordByUsername = userDao.findPasswordByUsername(username);
        if (passwordByUsername!=null&&passwordByUsername.equals(password))
        {
            return true;
        }else{
            return false;
        }
    }
}
