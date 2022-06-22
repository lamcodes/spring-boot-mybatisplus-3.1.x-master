package com.example.mybatisplus.exception;

import com.example.mybatisplus.common.ExceptionEnum;

/**
 * @Description 自定义异常，搭配全局异常捕获处理类
 * @Author zkp
 * @Date 2022-06-22 21:18
 */
public class BusinessException extends Exception{
    private ExceptionEnum exceptionEnum;
    private String code;
    private String errorMsg;

    public BusinessException() {
        super();
    }
/**
 * 下面对异常的设置不太理解，可以在抛出异常的时候对异常进行设置。
 */
    public BusinessException(ExceptionEnum exceptionEnum) {
        super("{code:" + exceptionEnum.getCode() + ",errorMsg:" + exceptionEnum.getMsg() + "}");
        this.exceptionEnum = exceptionEnum;
        this.code = exceptionEnum.getCode();
        this.errorMsg = exceptionEnum.getMsg();
    }

    public BusinessException(String code, String errorMsg) {
        super("{code:" + code + ",errorMsg:" + errorMsg + "}");
        this.code = code;
        this.errorMsg = errorMsg;
    }

    public BusinessException(String code, String errorMsg, Object... args) {
        super("{code:" + code + ",errorMsg:" + String.format(errorMsg, args) + "}");
        this.code = code;
        this.errorMsg = String.format(errorMsg, args);
    }

    public ExceptionEnum getExceptionEnum() {
        return exceptionEnum;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
