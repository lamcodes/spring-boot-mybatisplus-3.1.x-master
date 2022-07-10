package com.example.mybatisplus.controller;


import com.example.mybatisplus.common.ExceptionEnum;
import com.example.mybatisplus.config.ValidationCheck;
import com.example.mybatisplus.entity.Son;
import com.example.mybatisplus.entity.User;
import com.example.mybatisplus.exception.BusinessException;
import com.example.mybatisplus.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
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
    @Autowired
    TestService testService;

    @GetMapping("/test1")
    public String test(){
        User byId = iUserService.getById(1);
        System.out.println(byId.toString());
        for (int i = 0; i < 10; i++) {
            log.info("googletest"+i);
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
    public String t11(HttpServletRequest request, HttpServletResponse response) throws BusinessException, IOException {
        if (false){
            throw new BusinessException(ExceptionEnum.BAD_REQUEST);
        }
        InputStream is = null;
        StringBuilder sb = new StringBuilder();
        int x=0;
        try
        {
            is = request.getInputStream();

            byte[] b = new byte[4096];
//            for (int n; (n = is.read(b)) != -1;)
//            {
//                sb.append(new String(b, 0, n));
//            }
            while ((x=is.read(b))!=-1){
                sb.append(new String(b, 0, x));
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
//        BufferedReader br = null;
//        StringBuilder sb = new StringBuilder("");
//        try
//        {
//            br = request.getReader();
//            String str;
//            while ((str = br.readLine()) != null)
//            {
//                sb.append(str);
//            }
//            br.close();
//        }
//        catch (IOException e)
//        {
//            e.printStackTrace();
//        }

        System.out.println("接收到的文件:"+sb.toString());
//        PrintWriter writer = response.getWriter();
//        writer.write(sb.toString());

        return sb.toString();
    }
    @PostMapping("h")
    public void gg(HttpServletRequest request,HttpServletResponse response) throws IOException {
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder("");
        try
        {
            br = request.getReader();
            String str;
            while ((str = br.readLine()) != null)
            {
                sb.append(str);
            }
            br.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        System.out.println("接收到的文件:"+sb.toString());
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter writer = response.getWriter();

        writer.write(sb.toString());
    }
    @GetMapping("t1")
    @Transactional(readOnly = false)
    public User t112() throws BusinessException, IOException {
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
    @GetMapping("tran")
    public String trantest() throws BusinessException, IOException {
        iUserService.save(new User("kok",123,LocalDateTime.now()));
        User user = testService.t112();
        return user.toString();
    }
    public static void main(String[] args) {
        User user = new User(1,"fda",11, LocalDateTime.now());
        Son son = new Son();

        ValidationCheck.check(user);
        System.out.println("===========");
    }
}
