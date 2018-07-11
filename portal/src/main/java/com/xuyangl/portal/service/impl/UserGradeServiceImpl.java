package com.xuyangl.portal.service.impl;

import com.xuyangl.portal.bean.Grade;
import com.xuyangl.portal.dao.GradeDao;
import com.xuyangl.portal.dao.UserDao;
import com.xuyangl.portal.service.UserGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @Description
 * @Author: liuXuyang
 * @studentNo 15130110024
 * @Emailaddress 1187697635@qq.com
 * @Date: 2018/7/10 00:12
 */
@Service
public class UserGradeServiceImpl implements UserGradeService{

    @Autowired
    private GradeDao gradeDao;
    @Autowired
    private UserDao userDao;
    @Override
    public List<Grade> findAllGrades(String username) {
        List<Grade> allGrades = gradeDao.findAllGrades(username);
        return allGrades;
    }

    /**
     *  给某个用户添加一个班级
     * @param grade
     * @param username
     * @return
     */
    @Override
    @Transactional
    public boolean addGradeOfUser(Grade grade, String username) {
        gradeDao.save(grade);
        int userId = userDao.findIdByUsername(username);
        int nextId = gradeDao.getNextId();
        gradeDao.addUserAndGrade(userId,nextId-1);
        return true;
    }
}
