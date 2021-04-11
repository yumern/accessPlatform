package com.zzu.hezhifeng.pojo.DO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class DataObj {
    private String sourceAddress;
    private String message;
    private String targetAddress;
}
