package com.server;

import com.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.testng.annotations.Test;

@Service(value = "user")
public class UserServce {
    @Autowired
    private UserDao userDao;
    public void add(){
        System.out.println("servce add");
        userDao.add();
    }
}


