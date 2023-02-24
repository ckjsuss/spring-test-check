package com.zyzh.test.result;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * @Title: 统一封装结果类
 * @Description:
 * @author: Leo wey
 * @date: 2023/2/22 16:38
 * @Version: 1.0
 */
public class R<T> implements Serializable {
    private static final Logger logger = LoggerFactory.getLogger(R.class);

    private Integer code;
    private String msg;
    private T data;

    public static <T> R<T> success(int code, String msg, T data) {
        R<T> result = new R<>();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    public static <T> R<T> fail(int code, String msg, T data) {
        R<T> result = new R<>();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> R<T> success(T data) {
        return success(200, "操作成功", data);
    }

    public static <T> R<T> fail(String msg) {
        return fail(500, msg, null);
    }
}