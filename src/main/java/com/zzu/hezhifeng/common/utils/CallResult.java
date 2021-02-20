package com.zzu.hezhifeng.common.utils;

import java.io.Serializable;

public class CallResult<T> implements Serializable {
    private static final Long seriaVersionUID = -1231234234L;
    private Integer code;
    private String message;
    private T data;
    private String exception;

    protected CallResult(Integer code, String message, T data, Throwable throwable){
        this.code = code;
        this.message = message;
        this.data = data;
        this.exception = throwable.toString();
    }

    public static <T> CallResult<T> success(T data){
        return new CallResult(1, "success", data, (Throwable)null);
    }
    public static CallResult success(){
        return success((Object)null);
    }
    public static CallResult error(Integer code, String message, Throwable throwable){
        return new CallResult(code, message, throwable, throwable);
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    @Override
    public String toString() {
        return "CallResult{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                ", exception='" + exception + '\'' +
                '}';
    }
}
