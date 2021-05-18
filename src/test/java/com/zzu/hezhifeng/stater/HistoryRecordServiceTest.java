package com.zzu.hezhifeng.stater;

import com.zzu.hezhifeng.pojo.Param.HistoryRecordParam;
import com.zzu.hezhifeng.pojo.VO.HistoryRecordVO;
import com.zzu.hezhifeng.service.history.HistoryRecordService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class HistoryRecordServiceTest extends BaseTest{
    @Autowired
    private HistoryRecordService recordService;
    @Test
    public void testList(){
        ArrayList<HistoryRecordVO> list = recordService.list(new HistoryRecordParam());
        list.forEach(obj -> {
            System.out.println(obj);
        });
    }
}
