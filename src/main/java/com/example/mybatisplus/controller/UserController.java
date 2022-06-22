package com.example.mybatisplus.controller;


import com.example.mybatisplus.common.ExceptionEnum;
import com.example.mybatisplus.config.ValidationCheck;
import com.example.mybatisplus.entity.User;
import com.example.mybatisplus.exception.BusinessException;
import com.example.mybatisplus.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author huzhiting
 * @since 2019-06-03
 */
@RestController
@RequestMapping("user")
@Slf4j
public class UserController {

    @Autowired
    IUserService iUserService;

    @GetMapping("/test1")
    public String test(){
        User byId = iUserService.getById(1);
        System.out.println(byId.toString());
        for (int i = 0; i < 10; i++) {
            log.info("testsatlog"+i);
        }
        for (int i = 0; i < 10; i++) {
            log.debug("debug"+i);
        }
        for (int i = 0; i < 10; i++) {
            log.warn("warn"+i);
        }
        for (int i = 0; i < 10; i++) {
            log.error("error"+i);
        }
        return byId.toString();
    }

    @GetMapping("t")
    public String t11() throws BusinessException {
        if (true){
            throw new BusinessException(ExceptionEnum.BAD_REQUEST);
        }

        return "ffff";
    }
    @GetMapping("t1")
    public User t112() throws BusinessException {
        User user = new User();
        user.setAge(11);
        user.setName("张坤朋");
        return user;
    }
    public static void main(String[] args) {
        User user = new User(1,"fda",11, LocalDateTime.now());

        ValidationCheck.check(user);
        System.out.println("===========");
    }
}
