package com.zzu.hezhifeng.common.utils;

public enum StatusCode {
    SUCCESS(0, "SUCCESS"),
    FAILED(1, "FAILED");

    StatusCode(Integer code, String desc){
        this.code = code;
        this.desc = desc;
    }

    private Integer code;
    private String desc;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
