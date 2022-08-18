package org.example.test;


import cn.hutool.core.util.StrUtil;
import cn.hutool.system.SystemUtil;
import com.baomidou.mybatisplus.core.conditions.AbstractWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import org.example.Application;
import org.example.mapper.UserMapper;
import org.example.pojo.User;
import org.example.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MybatisPlusTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testQueue(){
        List<User> list = userService.list();
        list.forEach(user -> {
            System.out.println(user.getName() + " " + user.getEmail());
        });
    }

    @Test
    public void testCount(){
        System.out.println("count = " + userService.count());
    }

    @Test
    public void testLogicDelete(){
        userMapper.deleteById(1);
        System.out.println("success delete");
    }

    @Test
    public void testWrapper(){
        AbstractWrapper wrapper = new QueryWrapper();
        wrapper.eq( "id", "1");
        User one = userService.getOne(wrapper);
        System.out.println(one.toString());
    }
}
