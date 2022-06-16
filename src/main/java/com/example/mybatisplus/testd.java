package com.example.mybatisplus;

import com.example.mybatisplus.entity.User;
import com.example.mybatisplus.kafka.KafkaProducer;
import com.example.mybatisplus.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
//import org.junit.Test;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author zkp
 * @Date 2022-06-13 21:18
 */
@SpringBootTest
@Slf4j
public class testd {

    @Autowired
    KafkaProducer kafkaProducer;

    @Test
    public void testDemo() throws InterruptedException {
        log.info("start send");
        kafkaProducer.send("I am Lvshen");
        log.info("end send");
        // 休眠10秒，为了使监听器有足够的时间监听到topic的数据
        Thread.sleep(10);
    }
    @Autowired
    UserMapper userMapper;
@Test
public void test1(){
    Map<String, Object> selectbb = userMapper.selectbb(11);
    System.out.println(selectbb);
    List<User> selecta = userMapper.selectList(null);
    selecta.forEach(System.out::println);
//        User user1 = new User();
//        user1.setBir(LocalDateTime.now()).setAge("11").setName("xiaoli");
//        userMapper.insert(user1);
}
}
