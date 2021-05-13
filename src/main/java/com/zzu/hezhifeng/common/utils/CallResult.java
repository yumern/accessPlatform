package com.zzu.hezhifeng.common.utils;

import java.io.Serializable;

public class CallResult<T> implements Serializable {
   private T data;
   private Integer code;
   private String message;
   private String exception;

    public static CallResult success() {
        return success((Object)null);
    }

    public static <T> CallResult<T> success(T data) {
        return new CallResult(StatusCode.SUCCESS, StatusCode.SUCCESS.getDesc(), data);
    }

    public static<T> CallResult error(T data) {
        return new CallResult(StatusCode.FAILED, StatusCode.FAILED.getDesc(), data);
    }

    public CallResult() {
    }

    protected CallResult(StatusCode code, String message, T data) {
        this.code = code.getCode();
        this.message = message;
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }
}
