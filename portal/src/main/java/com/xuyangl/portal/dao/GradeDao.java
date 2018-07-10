package com.xuyangl.portal.dao;

import com.xuyangl.portal.bean.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Description
 * @Author: liuxuejiao
 * @studentNo 15050410028
 * @Emailaddress 1011522037@qq.com
 * @Date: 2018/7/8 19:23
 */
@Repository
public interface GradeDao extends JpaRepository<Grade,Long> {
}
