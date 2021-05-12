package com.zzu.hezhifeng.dao;

import com.zzu.hezhifeng.common.base.dao.AbstractDAO;
import com.zzu.hezhifeng.pojo.DO.ProjectRecordDO;
import com.zzu.hezhifeng.pojo.Param.ProjectRecordParam;
import com.zzu.hezhifeng.pojo.VO.ProjectRecordVO;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRecordDAO extends AbstractDAO<ProjectRecordDO, ProjectRecordVO, ProjectRecordParam> {
}
