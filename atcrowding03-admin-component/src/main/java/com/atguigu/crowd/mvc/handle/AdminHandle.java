package com.atguigu.crowd.mvc.handle;

import com.atguigu.crowd.entity.Admin;
import com.atguigu.crowd.service.api.AdminUservice;
import com.atguigu.util.CrowdConstant;
import com.atguigu.util.CrowdUtil;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.InetAddress;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: GaoUP
 * @Date 2021/10/13 8:04
 * @Version 1.0
 */
@Controller
public class AdminHandle {
    @Autowired
    AdminUservice adminUservice;

    //对编辑页进行修改
    @RequestMapping("/admin/do/modify.do")
    public String doModify(Admin admin,
                           @RequestParam(value = "keyword",defaultValue = "") String keyword,
                           @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum){
        System.out.println(admin.getUserName());
            adminUservice.modify(admin);
        return "redirect:/admin/to/pageInfo.html?pageNum="+pageNum+"&keyword="+keyword;
    }

    // 转发到修改页面
    @RequestMapping("/admin/to/edit.html")
    public String toDdit(@RequestParam("adminId") Integer adminId,ModelMap map){
        Admin admin = adminUservice.getByIdAdmin(adminId);
        map.addAttribute("Admin",admin);
        return "admin-edit";
    }

    // 添加一名用户
    @RequestMapping("/admin/save.do")
    public String add(Admin admin){
        adminUservice.saveAdmin(admin);
        return "redirect:/admin/to/pageInfo.html?pageNum="+Integer.MAX_VALUE;
    }
    // 删除用户
    @RequestMapping("/admin/remove/{id}/{pageNum}/{keyword}.do")
    public String remove(@PathVariable("id") Integer id,
                         @PathVariable("pageNum") Integer pageNum,
                         @PathVariable("keyword") String keyword){
        System.out.println("到了");
            adminUservice.remove(id);
        return "redirect:/admin/to/pageInfo.html?pageNum="+pageNum+"&keyword="+keyword;
    }

    // 对查询用户权限进行分页针对关键词
    @RequestMapping("/admin/to/pageInfo.html")
    public String getPageInfo(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                              @RequestParam(value = "pageSize",defaultValue = "5")Integer pageSize,
                              @RequestParam(value = "keyword",defaultValue = "") String keyword,
                               ModelMap map){
        System.out.println(keyword+"---keyword当前值"+keyword.length());
        PageInfo<Admin> pageInfo = adminUservice.selectByKeyWord(keyword, pageNum, pageSize);
        map.addAttribute(CrowdConstant.ATTR_NAME_PAGE_INFO,pageInfo);
        return "admin-page";
    }
    //添加一个session属性用户 跳转到主页面
    @RequestMapping("/admin/to/login.do")
    public String loginDo(@RequestParam("userAcct")      String userAcct,
                          @RequestParam("userPassword")  String userPassword,
                          HttpSession session , HttpServletRequest request){

        Admin admin = adminUservice.queryAdminAcct(userAcct, userPassword);
        request.getSession().setAttribute(CrowdConstant.MESSAGE_LOGIN_ADMIN_USER,admin);
        session.setAttribute(CrowdConstant.MESSAGE_LOGIN_ADMIN_USER,admin);
        return "redirect:/mainDo/main.do";
    }

    //退出当前用户的session域
    @RequestMapping(value = "/admin/do/logout.do")
    public String doLogout(HttpSession session,HttpServletRequest request) {
        session.removeAttribute(CrowdConstant.MESSAGE_LOGIN_ADMIN_USER);
        // 强制Session失效
        session.invalidate();
        return "redirect:/admin/to/login.do";
    }
//    @RequestMapping("/mainDo")
//    public String mianDo(){
//        return "admin-main";
//    }


}
