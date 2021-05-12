package com.zzu.hezhifeng.dao;

import com.zzu.hezhifeng.common.base.dao.AbstractDAO;
import com.zzu.hezhifeng.pojo.DO.ProjectDO;
import com.zzu.hezhifeng.pojo.Param.ProjectParam;
import com.zzu.hezhifeng.pojo.VO.ProjectVO;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectDAO extends AbstractDAO<ProjectDO, ProjectVO, ProjectParam> {
}
