package com.zzu.hezhifeng.dao;

import com.zzu.hezhifeng.common.base.dao.AbstractDAO;
import com.zzu.hezhifeng.pojo.DO.ProjectDetailsDO;
import com.zzu.hezhifeng.pojo.Param.ProjectDetailsParam;
import com.zzu.hezhifeng.pojo.VO.ProjectDetailsVO;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectDetailsDAO extends AbstractDAO<ProjectDetailsDO, ProjectDetailsVO, ProjectDetailsParam> {
}
