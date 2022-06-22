package com.example.mybatisplus.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description 设置统一返回体，有code，和message，data为具体内容。搭配枚举类（ResultMsgEnum）设置code和message
 * @Author zkp
 * @Date 2022-06-22 21:23
 */
@Data
public class Result<T> implements Serializable {
    private int code;

    private String message;

    private T data;

    public Result() {}
    public Result(int code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 成功
     */
    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<T>();
        result.setCode(ResultMsgEnum.SUCCESS.getCode());
        result.setMessage(ResultMsgEnum.SUCCESS.getMessage());
        result.setData(data);
        return result;
    }

    /**
     * 失败
     */
    public static <T> Result<T> error(int code, String message) {
        return new Result(code, message);
    }

    public static <T> Result<T> error(ExceptionEnum e) {
        Result result = new Result();
        result.setCode(Integer.valueOf(e.getCode()));
        result.setMessage(e.getMsg());
        result.setData(e.getMsg());
        return result;
    }
}
