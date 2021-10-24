package com.atguigu.crowd.mvc.intercpetor;

import com.atguigu.crowd.entity.Admin;
import com.atguigu.exception.AccessForbidden;
import com.atguigu.util.CrowdConstant;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: GaoUP
 * @Date 2021/10/14 19:22
 * @Version 1.0
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        1.
        HttpSession session = request.getSession();
        Admin admin =(Admin)session.getAttribute(CrowdConstant.MESSAGE_LOGIN_ADMIN_USER);
        if (admin==null){
                throw new AccessForbidden(CrowdConstant.MESSAGE_ACCESS_FORBIDDEN);
        }
        return true;
    }
}
