package com.lst.demo.service.impl;

import com.lst.demo.dao.DemoDao;
import com.lst.demo.entity.User;
import com.lst.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService{
    @Autowired
    private DemoDao demoDao;

    @Override
    public User getUser(Long id) {
        return demoDao.getUser(id);
    }
}
