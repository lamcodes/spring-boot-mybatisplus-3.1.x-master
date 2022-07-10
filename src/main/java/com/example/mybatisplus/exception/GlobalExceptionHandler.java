package com.example.mybatisplus.exception;

import com.example.mybatisplus.common.ExceptionEnum;
import com.example.mybatisplus.common.Result;
import com.example.mybatisplus.common.ResultMsgEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.errors.AuthorizationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.security.auth.message.AuthException;
import javax.servlet.http.HttpServletRequest;

/**
 * @Description @RestControllerAdvice和@ControllerAdvice
 *  因为@RestControllerAdvice源码中有@ControllerAdvice注解和@ResponseBody注解，
 * 当自定义类加@RestControllerAdvice注解时，
 * 方法自动返回json数据，每个方法无需再添加@ResponseBody注解
 * 使用@ControllerAdvice对controller进行增强
 * @Author zkp
 * @Date 2022-06-22 21:26
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(AuthException.class)
    public String errorHandler(AuthorizationException e) {
        log.error("没有通过权限验证！", e);
        return "没有通过权限验证！";
    }

    @ExceptionHandler(Exception.class)
    public Result execption(Exception e) {
        log.error("未知异常！", e);
        return Result.error(ResultMsgEnum.SERVER_BUSY.getCode(),ResultMsgEnum.SERVER_BUSY.getMessage());
    }

    @ExceptionHandler(value =BusinessException.class)
    public Result exceptionHandler(HttpServletRequest req, Exception e){
        log.error("请求的url："+req.getRequestURI());
        log.error("未知异常！原因是:",e);
        return Result.error(ExceptionEnum.INTERNAL_SERVER_ERROR);
    }
}
