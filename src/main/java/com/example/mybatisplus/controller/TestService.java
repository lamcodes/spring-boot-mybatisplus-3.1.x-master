package com.example.mybatisplus.controller;

import com.example.mybatisplus.entity.User;
import com.example.mybatisplus.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @Description TODO
 * @Author zkp
 * @Date 2022-07-05 21:59
 */
@Service
public class TestService {
    @Resource
    IUserService iUserService;
    @Transactional
    public User t112()  {
        User user = new User();
        user.setAge(11);
        user.setName("张坤朋");
        user.setBir(LocalDateTime.now());
        boolean save = iUserService.save(user);
        int i = 10/0;
//        System.out.println(request.getReader().ready());
//
//        System.out.println(request.getReader().readLine());
//        System.out.println(request.getReader().ready());
        return user;
    }
}
