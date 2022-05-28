package com.example.mybatisplus.config;

/**
 *  参数校验注解
 *  对添加注释的属性进行非空校验与正则校验
 * @author zkp
 * @date 2022/5/21 18:08
 */

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE,
        ElementType.CONSTRUCTOR, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyValidation {

    //错误信息
    String message() default "参数不能为空";

    //正则表达式
    String pattern() default "";

}
