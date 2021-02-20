package com.zzu.hezhifeng.service.impl;

import com.zzu.hezhifeng.dao.ProjectRelationDAO;
import com.zzu.hezhifeng.pojo.DO.ProjectRelation;
import com.zzu.hezhifeng.pojo.DO.User;
import com.zzu.hezhifeng.pojo.Param.ProjectRelationParam;
import com.zzu.hezhifeng.service.ProjectRelationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Optional;

public class ProjectRelationServiceImpl implements ProjectRelationService {
    @Autowired
    private ProjectRelationDAO relationDAO;

    @Override
    public Long insert(ProjectRelation data) {
        Long res = relationDAO.insert(data);
        return res;
    }

    @Override
    public void delete(ProjectRelation data) {
        relationDAO.delete(data);
    }

    @Override
    public void update(ProjectRelation data) {
        relationDAO.update(data);
    }

    @Override
    public Optional<ProjectRelation> find(ProjectRelationParam param) {
        ArrayList<ProjectRelation> relationList = relationDAO.list(param);
        if (relationList.isEmpty()){
            throw new NullPointerException("元素不存在");
        }
        return Optional.of(relationList.get(0));
    }

    @Override
    public ArrayList<ProjectRelation> list(ProjectRelationParam param) {
        ArrayList<ProjectRelation> relationList = relationDAO.list(param);
        return relationList;
    }
}
