package com.example.mybatisplus.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.example.mybatisplus.config.MyValidation;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author huzhiting
 * @since 2019-06-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class User implements Serializable {

    private int id;
    @MyValidation(message = "姓名不可为空")		//非空校验
    private String name;
    @MyValidation(pattern = "\\d+",message = "年龄只能是数字")
    private String age;

    private LocalDateTime bir;

    public User(){
    }
    public User(int i, String fda, String fdas, LocalDateTime now) {
        id=i;
        name=fda;
        age=fdas;
        bir=now;
    }
}
