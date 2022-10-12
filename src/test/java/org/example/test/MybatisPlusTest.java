package org.example.test;


import cn.hutool.core.util.StrUtil;
import cn.hutool.system.SystemUtil;
import com.baomidou.mybatisplus.core.conditions.AbstractWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
//使用@MybatisTest注解后用内存数据库，非内存数据库需要加下述接口
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MybatisPlusTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    /**
     * 测试多个查询
     */
    @Test
    public void testQueue() {
        List<User> list = userService.list();
        list.forEach(user -> {
            System.out.println(user.getName() + " " + user.getEmail());
        });
    }



    @Test
    public void testInsertBatch(){
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 10  ; i++) {
            User user = new User();
            user.setName("xbh" + i);
            user.setEmail("xbh" + i + "@qq.com");
            list.add(user);
        }
        userService.saveBatch(list);
    }
    /**
     * 测试数据库
     */
    @Test
    public void testCount() {
        System.out.println("count = " + userService.count());
    }

    /**
     * 测试单个删除
     */
    @Test
    public void testLogicDelete() {
        userMapper.deleteById(1);
        System.out.println("success delete");
    }

    /**
     * 测试修饰类
     */
    @Test
    public void testWrapper() {
        AbstractWrapper wrapper = new QueryWrapper();
        wrapper.eq("id", "1");
        User one = userService.getOne(wrapper);
        System.out.println(one.toString());
    }

    @Test
    public void testInsert() {
        User user = new User();
        user.setEmail("xxx@12334.com");
        user.setAge(32);
        user.setName("john");
        userMapper.insert(user);
        System.out.println(user.getId());
    }


    @Test
    public void testSelectMapId(){
        Map<String, Object> stringObjectMap = userMapper.selectMapById(2L);
        System.out.println(stringObjectMap);

    }
    @Test
    public void testDelete(){

        AbstractWrapper wrapper = new UpdateWrapper();
        wrapper.eq("id", 1L);
        int delete = userMapper.delete(wrapper);
        System.out.println(delete);
    }
    /**
     * 测试分页
     */
    @Test
    public void testPage() {
        int curPage = 1;
        int limit = 2;
        IPage<User> page = new Page<>(curPage, limit);
        AbstractWrapper wrapper = new QueryWrapper();
        IPage<User> iPage = userMapper.selectPage(page, wrapper);
        List<User> recorsds = iPage.getRecords();
        System.out.println(iPage.getRecords());

    }


    /**
     * 测试乐观锁
     */
    @Test
    public void testOptimisticLocker() {
        UpdateWrapper<User> wrapper = new UpdateWrapper();
        User user = userMapper.selectById(1);
        user.setAge(12);
        userMapper.updateById(user);
    }

    /**
     * 测试乐观锁冲突
     */
    @Test
    public void testOptimisticLockerFail() {
        User user = userService.getById(1);
        user.setAge(2);
        User user2 = userService.getById(1);
        user2.setAge(3);
        userService.updateById(user2);
        userService.updateById(user);
    }

    /**
     * 测试全表更新
     * Cause: com.baomidou.mybatisplus.core.exceptions.MybatisPlusException: Prohibition of table update operation
     */
    @Test
    public void testFullTableUpdate() {
        User user = new User();
        user.setId(999L);
        user.setName("Alisa");
        user.setEmail("Alisa@gmail.com");
        user.setAge(23);
        userService.saveOrUpdate(user, null);
    }

    /**
     * 部分更新
     */
    @Test
    public void testPartTableUpdate() {
        LambdaUpdateWrapper<User> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(User::getId, 1L);
        User user = new User();
        user.setAge(81);
        user.setName("CusterName");
        user.setEmail("custername@qq.com");
        userService.saveOrUpdate(user, wrapper);
    }


}
