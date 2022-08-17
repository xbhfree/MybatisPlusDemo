package org.example.test;
//import java.sql.*;
import org.example.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * SpringBaseTest
 *
 * @author trang
 */
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public  class SpringBaseTest {
//
//    protected static final Logger log = LoggerFactory.getLogger(SpringBaseTest.class);
//    @Test
//    public void testMybatis(){
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            //如果显示没有这个包,需要下载connect for java并添加相应jar包
//
//            String databaseName = "mybatis_plus";// 确保在MySQL数据库中创建CREATE好的数据库。
//            String userName = "root";// MySQL默认的root账户名
//            String password = "xbh123456";// 默认的root账户密码为空,或者用户设置的密码
//            //端口号一般默认为3306,在安装mySQL时候可以自己修改.
//            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + databaseName, userName, password);
//
//            Statement stmt = conn.createStatement();
//
//            String sql = "select * from user where id = 1";
//
//            // 创建数据库中的表，
//            ResultSet rs = stmt.executeQuery(sql);
//            while (rs.next()){
//                System.out.println(rs.getString("name"));
//            }
//            rs.close();
//            stmt.close();
//            conn.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

}