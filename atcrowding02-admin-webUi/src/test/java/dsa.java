import com.atguigu.crowd.entity.Admin;
import com.atguigu.crowd.mapper.AdminMapper;
import com.atguigu.crowd.service.api.AdminUservice;
import com.atguigu.util.CrowdUtil;
import com.atguigu.util.MD5Util;
import com.github.pagehelper.PageInfo;
import com.gjp.ConeTest;
import com.server.UserServce;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringJUnitConfig(locations = {"classpath:spring-persist-batis.xml","classpath:spring-persist-tx.xml"})
public class dsa {
    @Test
    public void dad(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-persist-batis.xml");
        UserServce userservce = context.getBean("user", UserServce.class);
        userservce.add();
        ConeTest coneTest = context.getBean("coneTest", ConeTest.class);
        Connection connection = coneTest.getConnection();
        System.out.println(connection);

    }
        @Autowired
        DataSource dataSource;
        @Test
        public void  testConnection() throws SQLException {
            Connection connection = dataSource.getConnection();
            System.out.println(connection);
        }
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private AdminUservice adminUservice;
    @Test
    public void testInsertAdmin(){
        Admin admin;
        int count=0;

            admin = new Admin(null,"bb","123123","rui","rui"+"@qq.com",null);
            adminUservice.saveAdmin(admin);

    }
    @Test
    public void testSelect(){
        ArrayList<Admin> admins = adminMapper.selectByKeyWord("5");
        Iterator<Admin> iterator = admins.iterator();
        while (iterator.hasNext()){
            Admin next = iterator.next();
            System.out.println(next.getId());
        }
        PageInfo<Admin> pageInfo = adminUservice.selectByKeyWord("", 1, 5);

    }
    @Test
    public void testCreateData(){
        Admin admin;
        for (int i = 0; i < 10; i++) {
            String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            String password = String.valueOf((int)(Math.random()*900000 + 100000));;
            String userPswd = MD5Util.md5(password);
            String login = getStringRandom(5);
            String userName = login.substring(0,3);
            admin = new Admin(null,captureName(login),userPswd,userName,userName+"@qq.com",date);
            adminMapper.insert(admin);
        }
    }
    //生成随机用户名，数字和字母组成,
    public static String getStringRandom(int length) {
        String val = "";
        Random random = new Random();

        //参数length，表示生成几位随机数
        for(int i = 0; i < length; i++) {
            val += (char)(random.nextInt(26)+97);
        }
        return val;
    }
    public static String captureName(String name) {
        char[] cs=name.toCharArray();
        cs[0]-=32;
        return String.valueOf(cs);
    }

}
