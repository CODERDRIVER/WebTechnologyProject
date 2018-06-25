package com.xuyangl.portal.dao;

import com.xuyangl.portal.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @Description
 * @Author: liuXuyang
 * @studentNo 15130110024
 * @Emailaddress 1187697635@qq.com
 * @Date: 2018/6/25 17:26
 */
@Repository
public interface UserDao extends JpaRepository<User, Integer> {

    @Query("select password from t_user where username = :username")
    public String findPasswordByUsername(String username);
}
