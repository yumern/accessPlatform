package com.zzu.hezhifeng.service.history.impl;

import com.google.common.base.Optional;
import com.zzu.hezhifeng.dao.HistoryRecordDAO;
import com.zzu.hezhifeng.pojo.Param.HistoryRecordParam;
import com.zzu.hezhifeng.pojo.VO.HistoryRecordVO;
import com.zzu.hezhifeng.service.history.HistoryRecordService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class HistoryRecordServiceImpl implements HistoryRecordService {
    @Autowired
    private HistoryRecordDAO recordDAO;
    @Override
    public Long insert(HistoryRecordVO data) {
        return this.recordDAO.insert(data);
    }

    @Override
    public void delete(HistoryRecordVO data) {
        this.recordDAO.delete(data);
    }

    @Override
    public void update(HistoryRecordVO data) {
        this.recordDAO.update(data);
    }

    @Override
    public Optional<HistoryRecordVO> find(HistoryRecordParam param) {
        ArrayList<HistoryRecordVO> list = this.recordDAO.list(param);
        if (CollectionUtils.isNotEmpty(list)){
            return Optional.of(list.get(0));
        }
        return Optional.absent();
    }

    @Override
    public ArrayList<HistoryRecordVO> list(HistoryRecordParam param) {
        return this.recordDAO.list(param);
    }
}
