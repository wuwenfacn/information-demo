package com.information.utils;

import java.io.Serializable;

/**
 * @Author qiaoshu
 * @JDK 1.8
 * Date: 2020-10-19  21:12
 * Description:
 */
public class ResponseEntity<T> {
    private String code;//状态码
    private String message;//信息
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
