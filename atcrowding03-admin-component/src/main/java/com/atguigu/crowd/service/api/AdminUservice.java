package com.atguigu.crowd.service.api;

import com.atguigu.crowd.entity.Admin;
import com.github.pagehelper.PageInfo;

import java.util.ArrayList;

public interface AdminUservice {
    // 添加用户
    void saveAdmin(Admin admin);

    ArrayList<Admin> getAll();

    Admin queryAdminAcct(String userAcct, String userPassword);
    // 通过关键字查询Admin 返回Admin用户集合
    PageInfo<Admin> selectByKeyWord(String keyword,Integer pageNum,Integer pageSize);
    //删除用户
    Boolean remove(Integer id);
    //修改用户信息
    void modify(Admin admin);
    //查询一个用户
    Admin getByIdAdmin(Integer id);
}
