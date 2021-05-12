package com.zzu.hezhifeng.service.project.impl;

import com.google.common.base.Optional;
import com.zzu.hezhifeng.common.base.dao.AbstractDAO;
import com.zzu.hezhifeng.common.base.service.AbstractDVService;
import com.zzu.hezhifeng.dao.ProjectDAO;
import com.zzu.hezhifeng.pojo.DO.ProjectDO;
import com.zzu.hezhifeng.pojo.Param.ProjectParam;
import com.zzu.hezhifeng.pojo.VO.ProjectVO;
import com.zzu.hezhifeng.service.project.ProjectService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectDAO projectDAO;

    @Override
    public Long insert(ProjectVO data) {
        return projectDAO.insert(data);
    }

    @Override
    public void delete(ProjectVO data) {
        projectDAO.delete(data);
    }

    @Override
    public void update(ProjectVO data) {
        projectDAO.update(data);
    }

    @Override
    public Optional<ProjectVO> find(ProjectParam param) {
        ArrayList<ProjectVO> list = this.projectDAO.list(param);
        if (CollectionUtils.isNotEmpty(list)){
            return Optional.of(list.get(0));
        }
        return Optional.absent();
    }

    @Override
    public ArrayList<ProjectVO> list(ProjectParam param) {
        return this.projectDAO.list(param);
    }
}
