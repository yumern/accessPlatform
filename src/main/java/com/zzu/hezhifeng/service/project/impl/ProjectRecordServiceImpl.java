package com.zzu.hezhifeng.service.project.impl;

import com.google.common.base.Optional;
import com.zzu.hezhifeng.dao.ProjectRecordDAO;
import com.zzu.hezhifeng.pojo.Param.ProjectRecordParam;
import com.zzu.hezhifeng.pojo.VO.ProjectRecordVO;
import com.zzu.hezhifeng.service.project.ProjectRecordService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProjectRecordServiceImpl implements ProjectRecordService {
    @Autowired
    private ProjectRecordDAO recordDAO;

    @Override
    public Long insert(ProjectRecordVO data) {
        return recordDAO.insert(data);
    }

    @Override
    public void delete(ProjectRecordVO data) {
        this.recordDAO.delete(data);
    }

    @Override
    public void update(ProjectRecordVO data) {
        this.recordDAO.update(data);
    }

    @Override
    public Optional<ProjectRecordVO> find(ProjectRecordParam param) {
        ArrayList<ProjectRecordVO> list = this.recordDAO.list(param);
        if (CollectionUtils.isNotEmpty(list)){
            return Optional.of(list.get(0));
        }
        return Optional.absent();
    }

    @Override
    public ArrayList<ProjectRecordVO> list(ProjectRecordParam param) {
        return this.recordDAO.list(param);
    }
}
