package com.example.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.AbstractWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mybatisplus.entity.User;
import com.example.mybatisplus.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisplusApplicationTests {


    @Autowired
    UserMapper userMapper;
    @Test
    public void contextLoads() {
        List<User> users = userMapper.selectList(null);
       // users.forEach(x-> System.out.println(x));
        QueryWrapper queryWrapper = new QueryWrapper<>();
        Map<String, Object> map = new HashMap<>();
        map.put("name","dfa");
        map.put("age",11);
        map.put("id",1);
        queryWrapper.allEq(map);
        //List list = userMapper.selectList(queryWrapper);
        System.out.println(userMapper.selectOne(queryWrapper).toString());
//        int delete = userMapper.delete(queryWrapper);
//        System.out.println(delete);
        User user = userMapper.selectOne(queryWrapper);
        if (user==null){
            System.out.println("被删除了");
        }
        User user1 = new User();
        user1.setBir(LocalDateTime.now()).setAge("11").setId(1).setName("dfa");
//        userMapper.insert(user1);

    }
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
