package com.xuyangl.portal.service.impl;

import com.xuyangl.portal.bean.Grade;
import com.xuyangl.portal.dao.GradeDao;
import com.xuyangl.portal.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author: LeiYuQing
 * @studentNo 15130110106
 * @Emailaddress rimoly.7@gmail.com
 * @Date: 2018/7/8 19:59
 */
@Service
public class GradeServiceImpl implements GradeService{


    @Autowired
    private GradeDao gradeDao;
    /**
     * 查询所有的班级列表
     * @return
     */
    @Override
    public List<Grade> findAllGrade() {

        List<Grade> all = gradeDao.findAll();
        return all;
    }

    /**
     * 添加一个班级
     */
    @Override
    public boolean saveGrade(Grade grade) {
        gradeDao.save(grade);
        return true;
    }
}
