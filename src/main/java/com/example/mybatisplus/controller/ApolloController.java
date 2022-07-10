package com.example.mybatisplus.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author zkp
 * @Date 2022-06-28 21:26
 */
@RestController
@Slf4j
public class ApolloController {

    @Value( "${name}" )
    String dateValue;

    @GetMapping("test")
    public String test() {
        return "打印值: "+dateValue;
    }
}
