package org.example.test;

import org.example.mapper.UserMapper;
import org.example.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MybatisVersionTest {
    @Autowired
    private UserMapper userMapper;

    /**
     * 测试锁
     */
    @Test
    public void testVersion(){
        User user = userMapper.selectById(1579092756142350337L);
        System.out.println("user age = " + user.getAge());
        User user2 = userMapper.selectById(1579092756142350337L);
        System.out.println("user2 age = " + user2.getAge());
        user.setAge(user.getAge() + 20);
        userMapper.updateById(user);
        user2.setAge(user2.getAge() - 10);
        userMapper.updateById(user2);
        User user3 = userMapper.selectById(1579092756142350337L);
        // 只能执行第一个修改
        System.out.println("user3 age = " + user3.getAge());
    }


    /**
     * 测试锁优化流程
     */
    @Test
    public void testVersion2(){
        User user = userMapper.selectById(1579092756142350337L);
        System.out.println("user age = " + user.getAge());
        User user2 = userMapper.selectById(1579092756142350337L);
        System.out.println("user2 age = " + user2.getAge());
        user.setAge(user.getAge() + 20);
        userMapper.updateById(user);
        user2.setAge(user2.getAge() - 10);
        int result = userMapper.updateById(user2);
        if (result == 0){
            //失败再次修改
            User userFail = userMapper.selectById(1579092756142350337L);
            userFail.setAge(userFail.getAge() - 10);
            userMapper.updateById(userFail);
        }
        User user3 = userMapper.selectById(1579092756142350337L);
        // 只能执行第一个修改
        System.out.println("user3 age = " + user3.getAge());
    }
}
