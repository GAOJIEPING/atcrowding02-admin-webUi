package com.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{
    @Override
    public void add() {
        System.out.println("dao add()");
    }
    private void sada(){
        System.out.println("第二版本");
        System.out.println("大家好");
        System.out.println("我是热修复");
    }
}
