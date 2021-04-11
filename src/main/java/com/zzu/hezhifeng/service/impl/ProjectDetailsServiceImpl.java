package com.zzu.hezhifeng.service.impl;

import com.zzu.hezhifeng.dao.ProjectDetailsDAO;
import com.zzu.hezhifeng.pojo.DO.ProjectDetailsDO;
import com.zzu.hezhifeng.pojo.Param.ProjectDetailsParam;
import com.zzu.hezhifeng.pojo.VO.ProjectDetailsVO;
import com.zzu.hezhifeng.service.ProjectDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import com.google.common.base.Optional;

@Service
public class ProjectDetailsServiceImpl implements ProjectDetailsService {
    @Autowired
    private ProjectDetailsDAO projectDetailsDAO;


    @Override
    public Long insert(ProjectDetailsVO data) {
        Long res = projectDetailsDAO.insert(data);
        return res;
    }

    @Override
    public void delete(ProjectDetailsVO data) {
        projectDetailsDAO.delete(data);
    }

    @Override
    public void update(ProjectDetailsDO data) {
        projectDetailsDAO.update(data);
    }

    @Override
    public Optional<ProjectDetailsVO> find(ProjectDetailsParam param) {
        ArrayList<ProjectDetailsVO> detailList = projectDetailsDAO.list(param);
        if (detailList.isEmpty()){
            throw new NullPointerException("元素不存在");
        }
        return Optional.of(detailList.get(0));
    }

    @Override
    public ArrayList<ProjectDetailsVO> list(ProjectDetailsParam param) {
        ArrayList<ProjectDetailsVO> detailList = projectDetailsDAO.list(param);
        return detailList;
    }
}
