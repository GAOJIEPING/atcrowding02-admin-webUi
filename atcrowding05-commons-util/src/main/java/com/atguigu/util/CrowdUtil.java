package com.atguigu.util;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/*
    * 判断当前请求是否为Ajax请求
    * @param request 请求对象
    * @return
    *      true：当前请求为Ajax请求
    *      false：当前请求不是Ajax请求
 */
public class CrowdUtil {

//判断是否为JSON
    public static boolean  JudageIfJson(HttpServletRequest request){
        String accept = request.getHeader("Accept");
        String header = request.getHeader("X-Requested-With");

        return  (accept!=null&&accept.contains("application/json"))||
                (header!=null&&header.contains("XMLHttpRequest"));
    }



}
