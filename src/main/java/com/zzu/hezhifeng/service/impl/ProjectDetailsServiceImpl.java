package com.zzu.hezhifeng.service.impl;

import com.zzu.hezhifeng.dao.ProjectDetailsDAO;
import com.zzu.hezhifeng.pojo.DO.ProjectDetails;
import com.zzu.hezhifeng.pojo.Param.ProjectDetailsParam;
import com.zzu.hezhifeng.service.ProjectDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ProjectDetailsServiceImpl implements ProjectDetailsService {
    @Autowired
    private ProjectDetailsDAO projectDetailsDAO;


    @Override
    public Long insert(ProjectDetails data) {
        Long res = projectDetailsDAO.insert(data);
        return res;
    }

    @Override
    public void delete(ProjectDetails data) {
        projectDetailsDAO.delete(data);
    }

    @Override
    public void update(ProjectDetails data) {
        projectDetailsDAO.update(data);
    }

    @Override
    public Optional<ProjectDetails> find(ProjectDetailsParam param) {
        ArrayList<ProjectDetails> detailList = projectDetailsDAO.list(param);
        if (detailList.isEmpty()){
            throw new NullPointerException("元素不存在");
        }
        return Optional.of(detailList.get(0));
    }

    @Override
    public ArrayList<ProjectDetails> list(ProjectDetailsParam param) {
        ArrayList<ProjectDetails> detailList = projectDetailsDAO.list(param);
        return detailList;
    }
}
