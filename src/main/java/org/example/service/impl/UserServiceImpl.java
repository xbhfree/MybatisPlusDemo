package org.example.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.mapper.UserMapper;
import org.example.pojo.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author xbhfr
 */
@Service
@Transactional
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;

}
