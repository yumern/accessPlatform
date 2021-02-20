package com.zzu.hezhifeng.dao;

import com.zzu.hezhifeng.common.base.dao.AbstractDAO;
import com.zzu.hezhifeng.pojo.DO.ProjectRelation;
import com.zzu.hezhifeng.pojo.Param.ProjectRelationParam;
import com.zzu.hezhifeng.pojo.VO.ProjectRelationVO;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRelationDAO extends AbstractDAO<ProjectRelation, ProjectRelationVO, ProjectRelationParam> {
}
