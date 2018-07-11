package com.xuyangl.portal.service.impl;

import com.xuyangl.portal.bean.Document;
import com.xuyangl.portal.dao.DocumentDao;
import com.xuyangl.portal.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author: liuXuyang
 * @studentNo 15130110024
 * @Emailaddress 1187697635@qq.com
 * @Date: 2018/7/10 16:24
 */
@Service
public class DocumentServiceImpl implements DocumentService{

    @Autowired
    private DocumentDao documentDao;
    @Override
    public boolean saveDocument(Document document) {

        documentDao.save(document);
        return true;
    }
}
