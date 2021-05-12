package com.zzu.hezhifeng.pojo.DO;

import com.zzu.hezhifeng.pojo.VO.ProjectRecordVO;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class DataObj {
    /**
     * 所属项目id
     */
    private Long uid;
    /**
     * 认证秘钥
     */
    private String secretKey;
    /**
     * 通信数据格式
     */
    private ProjectRecordVO message;
}
