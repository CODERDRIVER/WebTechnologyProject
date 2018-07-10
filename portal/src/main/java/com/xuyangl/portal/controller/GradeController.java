package com.xuyangl.portal.controller;

import com.xuyangl.portal.bean.Grade;
import com.xuyangl.portal.domain.ResponseMessage;
import com.xuyangl.portal.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description
 * @Author: LeiYuQing
 * @studentNo 15130110106
 * @Emailaddress rimoly.7@gmail.com
 * @Date: 2018/7/6 20:01
 */
@RestController
@RequestMapping("/")
public class GradeController {

    @Autowired
    private GradeService gradeService;

    /**
     * 查询所有的班级列表
     * @return
     */
    @RequestMapping(value = "/grades",method = RequestMethod.GET)
    public List<Grade> findAll()
    {
        return gradeService.findAllGrade();
    }

    @RequestMapping(value = "/grade",method = RequestMethod.POST)
    public ResponseMessage saveGrade(Grade grade)
    {
        boolean b = gradeService.saveGrade(grade);
        if (b)
        {
            return new ResponseMessage("添加成功",1);
        }else{
            return new ResponseMessage("添加失败",0);
        }
    }

}
