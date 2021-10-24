package com.atguigu.crowd.mvc.handle;

import com.atguigu.crowd.entity.Admin;
import com.atguigu.crowd.entity.Student;
import com.atguigu.crowd.service.api.AdminUservice;
import com.atguigu.util.CrowdUtil;
import com.atguigu.util.ResultEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MyHandle {
   private final Logger logger = LoggerFactory.getLogger(MyHandle.class);
    @Autowired
    AdminUservice adminUservice;


    @ResponseBody
    @RequestMapping(value = "/send/t4.html",method = RequestMethod.POST)
    public ResultEntity<Student> receiveAjaxTest4(@RequestBody Student student){
        logger.info(String.valueOf(student));
        String a=null;
        System.out.println(a.length());
        return ResultEntity.successWithHaveData(student);
    }


    @ResponseBody
    @RequestMapping(value = "/send/t3.html",method = RequestMethod.POST)
    public String receiveAjaxTest3(@RequestBody Student student, HttpServletRequest request){

            logger.info(String.valueOf(student));
        boolean b = CrowdUtil.JudageIfJson(request);
        logger.info(String.valueOf(b));
        return "success";
    }

    @ResponseBody
    @RequestMapping(value = "/send/t2.html",method = RequestMethod.POST)
    public String receiveAjaxTest2(@RequestBody List<Integer> array){
        System.out.println("这是测试二的连接");
        for (Integer data : array) {
                logger.info(String.valueOf(data));
        }
        return "success";
    }

    @ResponseBody
    @RequestMapping(value ="/send/t1.html")
    public String receiveAjaxTest1(@RequestParam("array[]") List<Integer> arr){
        System.out.println("这是测试一的连接");
        for (Integer info : arr) {
            System.out.println(info);
            System.out.println("a-b");
        }
//        System.out.println(10/0);
        return "success";
    }
    @RequestMapping("/handle/test1.html")
    public String toIndex(Model model,HttpServletRequest request){
        ArrayList<Admin> all = adminUservice.getAll();
        model.addAttribute("all",all);
        boolean b = CrowdUtil.JudageIfJson(request);
        System.out.println("链接测试是否为ajax请求"+b);
        return "target";
    }


}
