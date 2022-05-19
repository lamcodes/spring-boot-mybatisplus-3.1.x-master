package com.example.mybatisplus.controller;


import com.example.mybatisplus.entity.User;
import com.example.mybatisplus.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author huzhiting
 * @since 2019-06-03
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    IUserService iUserService;
    @GetMapping("test1")
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

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("lizhi");
        strings.add("zlk");
        System.out.println(strings);
        List<String> strings2 = new ArrayList<>(strings);
        List<String> strings1 = strings;
//        strings1.set(0,"world");
//        System.out.println(strings1.remove(1));
//        System.out.println("string1"+strings1);
//        System.out.println("strings:"+strings);
        strings2.remove(1);
        System.out.println("strings2"+strings2);
        System.out.println("strings:"+strings);
    }
}
