package com.atguigu.crowd.service.impl;

import com.atguigu.crowd.entity.Admin;
import com.atguigu.crowd.entity.AdminExample;
import com.atguigu.crowd.mapper.AdminMapper;
import com.atguigu.crowd.service.api.AdminUservice;
import com.atguigu.exception.LoginAcctAlreadyInUseForUpdateException;
import com.atguigu.exception.LoginAlreadyFailedException;
import com.atguigu.util.CrowdConstant;
import com.atguigu.util.MD5Util;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

@Service
public class AdminUserviceImpl implements AdminUservice {
    @Autowired
    AdminMapper adminMapper;
    Logger logger;
    @Override
    public void saveAdmin(Admin admin) {
        admin.setUserPswd(MD5Util.md5(admin.getUserPswd()));

        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        admin.setCreateTime(date);

        try {
            adminMapper.insert(admin);
        } catch (Exception exception) {
            exception.printStackTrace();
//            logger.info("异常全类名："+exception.getClass().getName());
            if(exception instanceof DuplicateKeyException){
                  throw new LoginAlreadyFailedException(CrowdConstant.MESSAGE_LOGIN_ACCT_ALREADY_IN_USE);
            }
        }

    }

    @Override
    public ArrayList<Admin> getAll() {
        ArrayList<Admin> admins = (ArrayList)adminMapper.selectByExample(new AdminExample());
        return admins;
    }

    @Override
    public Admin queryAdminAcct(String userAcct, String userPassword) {
        // 1. 根据登录账号查询Admin对象
        // 创建AdminExample对象
        AdminExample adminExample = new AdminExample();
        // 创建Criteria对象
        AdminExample.Criteria criteria = adminExample.createCriteria();
        // 在Criteria对象中封装查询条件
        criteria.andLoginEqualTo(userAcct);
        // 调用AdminMapper的方法执行查询
        List<Admin> admins = adminMapper.selectByExample(adminExample);
        if (userPassword.length()==0||userPassword==null){
            throw new RuntimeException(CrowdConstant.MESSAGE_LOGIN_NOT_PSSWORD);
        }

        // 2.判断Admin对象是否为null
        if (admins.size()<1||admins==null){
            // 3.为null则抛出异常
            throw  new RuntimeException(CrowdConstant.MESSAGE_LOGIN_ACCT_FINDFAILED);
        }
        if (admins.size()>1){
            throw   new RuntimeException(CrowdConstant.MESSAGE_SYTEM_SERROR_NOT_UNIQUE);
        }
        // 4.Admin对象不为null，取出密码
        Admin user = admins.get(0);
        String userPswdwithDB = user.getUserPswd();
        // 5.将表单提交的明文密码进行加密
        String userPswdWithForm = MD5Util.md5(userPassword);
        System.out.println(userPassword+"原密码");
        System.out.println("数据库密码"+userPswdwithDB+"加密后的原密码"+userPswdWithForm);
        // 6.比较密码
        if (!Objects.equals(userPswdwithDB,userPswdWithForm)){
            // 7.结果不一致，抛异常
            throw new RuntimeException(CrowdConstant.MESSAGE_LOGIN_FAILED);
        }
            // 8.如果一致则返回Admin对象
            return user;
    }

    @Override
    public PageInfo<Admin> selectByKeyWord(String keyword,Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        ArrayList<Admin> list = adminMapper.selectByKeyWord(keyword);
        return new PageInfo<>(list);
    }

    @Override
    public Boolean remove(Integer id) {
        int i = adminMapper.deleteByPrimaryKey(id);
        return i>0;
    }

    @Override
    public void modify(Admin admin) {
        // 有选择的更新，对于null值字段不更新
        try {
            adminMapper.updateByPrimaryKeySelective(admin);
        } catch (Exception e) {
            e.printStackTrace();
            // 用户名重复：
            logger.info("异常全类名"+e.getClass().getName());
            if (e instanceof DuplicateKeyException) {
                throw new LoginAcctAlreadyInUseForUpdateException(CrowdConstant.MESSAGE_LOGIN_ACCT_ALREADY_IN_USE);
            }
        }
    }

    @Override
    public Admin getByIdAdmin(Integer id) {
        return adminMapper.selectByPrimaryKey(id);
    }
}
