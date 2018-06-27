package com.xuyangl.portal.service.impl;

import com.xuyangl.portal.bean.User;
import com.xuyangl.portal.dao.UserDao;
import com.xuyangl.portal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

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

    /**
     * 注册方法
     * @param user
     * @return
     */
    @Override
    public boolean register(User user) {
        //调用dao层持久化数据
        try {
            userDao.save(user);
            return true;
        } catch (Exception e)
        {
            return false;
        }
    }

    @Override
    public User findUser(User user) {

        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withMatcher("username", ExampleMatcher.GenericPropertyMatchers.caseSensitive())
                .withMatcher("password",ExampleMatcher.GenericPropertyMatchers.caseSensitive());

        Example<User> example = Example.of(user,exampleMatcher);
        List<User> all = userDao.findAll(example);
        return all.get(0);
    }
}
