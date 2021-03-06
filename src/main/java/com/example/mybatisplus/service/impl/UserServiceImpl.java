package com.example.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mybatisplus.entity.User;
import com.example.mybatisplus.mapper.UserMapper;
import com.example.mybatisplus.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author huzhiting
 * @since 2019-06-03
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Resource
    UserMapper userMapper;
//    @Transactional
    public User t112() {
        User user = new User();
        user.setAge(11);
        user.setName("张坤朋");
        user.setBir(LocalDateTime.now());
        userMapper.insert(user);
        int i = 10/0;
//        System.out.println(request.getReader().ready());
//
//        System.out.println(request.getReader().readLine());
//        System.out.println(request.getReader().ready());
        return user;
    }
}
