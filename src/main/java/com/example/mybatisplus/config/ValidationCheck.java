package com.example.mybatisplus.config;

import lombok.extern.slf4j.Slf4j;

//import javax.validation.Validation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zkp
 * @date 2022/5/21 18:06
 */
@Slf4j
public class ValidationCheck {

    /**
     * 校验方法
     * 扫描对象中的属性，查看是否有@Validation注解，有注解的进行校验
     *
     * @param o 要校验的对象，如入参对象
     */
    public static void check(Object o) {
        if (null == o) {
            return;
        }
        Class clazz = o.getClass();
        List<Field> fieldList = new ArrayList<Field>();
        while (clazz != null) {
            fieldList.addAll(new ArrayList<>(Arrays.asList(clazz.getDeclaredFields())));
            clazz = clazz.getSuperclass();
        }

        //变量对象的所有属性
        fieldList.forEach(field -> {
            field.setAccessible(true);
            try {
                Object value = field.get(o);

                //获取属性值
                MyValidation annotation = field.getAnnotation(MyValidation.class);
                if (null == annotation) {   //未加注解的不做处理
                    return;
                }
                checkNotNull(value, annotation);
                checkPattern(value, annotation);

            } catch (IllegalArgumentException | IllegalAccessException e) {
                log.info("Validation验证器数据解析失败:{}", e.getMessage());
            }
        });
    }

    /**
     * 非空判断
     *
     * @param value      属性值
     * @param validation 注解信息
     */
    private static void checkNotNull(Object value, MyValidation validation) {
        //log.info("开始校验非空");
        if (validation != null && value == null) {
            throw new RuntimeException(validation.message());
        }
    }

    /**
     * 正则校验
     *
     * @param value      属性值
     * @param validation 注解信息
     */
    private static void checkPattern(Object value, MyValidation validation) {
        if (null != validation.pattern() && validation.pattern().length() > 0) {//存在正则式
            //将validation中给定的正则表达式编译并赋予给Pattern类
            Pattern p = Pattern.compile(validation.pattern());
            //以p的规则匹配value中的值
            Matcher m = p.matcher(value.toString());
            if (!m.matches()) { //属性值不符合正则所制定的格式，抛出异常
                throw new RuntimeException(validation.message());
            }
        }
    }
}
