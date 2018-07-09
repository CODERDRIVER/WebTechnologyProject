package com.xuyangl.portal.service;

import com.xuyangl.portal.bean.Grade;

import java.util.List;

/**
 * @Description
 * @Author: liuxuejiao
 * @studentNo 15050410028
 * @Emailaddress 1011522037@qq.com
 * @Date: 2018/7/8 19:58
 */
public interface GradeService {

    //查询所有的班级列表
    public List<Grade> findAllGrade();

    //添加一个班级
    public boolean saveGrade(Grade grade);
}
