package com.zzu.hezhifeng.dao;

import com.zzu.hezhifeng.common.base.dao.AbstractDAO;
import com.zzu.hezhifeng.pojo.DO.HistoryRecordDO;
import com.zzu.hezhifeng.pojo.Param.HistoryRecordParam;
import com.zzu.hezhifeng.pojo.VO.HistoryRecordVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryRecordDAO extends AbstractDAO<HistoryRecordDO, HistoryRecordVO, HistoryRecordParam> {
}
