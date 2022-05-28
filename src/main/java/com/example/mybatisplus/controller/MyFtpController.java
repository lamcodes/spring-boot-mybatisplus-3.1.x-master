package com.example.mybatisplus.controller;

import com.example.mybatisplus.config.MySftpClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @author zkp
 * @date 2022/5/26 20:48
 */
@RestController
public class MyFtpController {


    @GetMapping("my1")
    public String ttt() throws FileNotFoundException {
        File file = new File("D:\\他的.txt");
        String path = "/root/zkp/test/";
        InputStream inputStream = new FileInputStream(file);
        MySftpClient.uploadFile(path,"test.txt",inputStream);

        return "成功感";
    }
}
