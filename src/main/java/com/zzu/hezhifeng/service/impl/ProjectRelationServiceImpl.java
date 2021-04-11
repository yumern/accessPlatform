package com.zzu.hezhifeng.service.impl;

import com.zzu.hezhifeng.common.base.dao.AbstractDAO;
import com.zzu.hezhifeng.dao.ProjectRelationDAO;
import com.zzu.hezhifeng.pojo.DO.ProjectRelationDO;
import com.zzu.hezhifeng.pojo.Param.ProjectRelationParam;
import com.zzu.hezhifeng.pojo.VO.ProjectRelationVO;
import com.zzu.hezhifeng.service.ProjectRelationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import com.google.common.base.Optional;
import org.springframework.stereotype.Service;

@Service
public class ProjectRelationServiceImpl implements ProjectRelationService {
    @Autowired
    private ProjectRelationDAO relationDAO;

    @Override
    public Long insert(ProjectRelationVO data) {
        Long res = relationDAO.insert(data);
        return res;
    }

    @Override
    public void delete(ProjectRelationVO data) {
        relationDAO.delete(data);
    }

    @Override
    public void update(ProjectRelationVO data) {
        relationDAO.update(data);
    }

    @Override
    public Optional<ProjectRelationVO> find(ProjectRelationParam param) {
        ArrayList<ProjectRelationVO> relationList = relationDAO.list(param);
        if (relationList.isEmpty()){
            throw new NullPointerException("元素不存在");
        }
        return Optional.of(relationList.get(0));
    }

    @Override
    public ArrayList<ProjectRelationVO> list(ProjectRelationParam param) {
        ArrayList<ProjectRelationVO> relationList = relationDAO.list(param);
        return relationList;
    }

    @Override
    public AbstractDAO getDAO() {
        return this.relationDAO;
    }
}
