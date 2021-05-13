package com.zzu.hezhifeng.stater.controller;

import com.zzu.hezhifeng.common.utils.CallResult;
import com.zzu.hezhifeng.pojo.Param.ProjectParam;
import com.zzu.hezhifeng.pojo.Param.ProjectRecordParam;
import com.zzu.hezhifeng.pojo.VO.ProjectRecordVO;
import com.zzu.hezhifeng.service.project.ProjectRecordService;
import com.zzu.hezhifeng.service.project.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;

@RestController
@RequestMapping("/accessPlatform/v1/project/record")
public class ProjectRecordController {
    @Autowired
    private ProjectRecordService projectRecordService;
    @Autowired
    private ProjectService projectService;

    @RequestMapping(
            method = RequestMethod.GET
    )
    public CallResult list(ProjectRecordParam recordParam){
        ArrayList<ProjectRecordVO> list = projectRecordService.list(recordParam);
        Long projectId = recordParam.getProjectId();
        ProjectParam param = new ProjectParam();
        param.setId(projectId);
        String listenIp = projectService.find(param).get().getListenIp();
        list.forEach(obj -> {
            obj.setListenIp(listenIp);
        });
        return CallResult.success(list);
    }

    @RequestMapping(
            method = RequestMethod.POST
    )
    public CallResult insert(@RequestBody ProjectRecordVO projectRecordVO){
        projectRecordVO.setGmtCreate(new Date());
        Long insert = this.projectRecordService.insert(projectRecordVO);
        return CallResult.success(insert);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            params = "/{id}"
    )
    public CallResult detail(@PathVariable Long id){
        ProjectRecordParam recordParam = new ProjectRecordParam();
        recordParam.setId(id);
        ProjectRecordVO projectRecordVO = projectRecordService.find(recordParam).get();
        Long projectId = projectRecordVO.getProjectId();
        ProjectParam param = new ProjectParam();
        param.setId(projectId);
        String listenIp = projectService.find(param).get().getListenIp();
        projectRecordVO.setListenIp(listenIp);
        return CallResult.success(projectRecordVO);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/{id}"
    )
    public CallResult update(@PathVariable Long id, @RequestBody ProjectRecordVO vo){
        vo.setId(id);
        vo.setGmtModified(new Date());
        projectRecordService.update(vo);
        return CallResult.success();
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/{id}"
    )
    public CallResult delete(@PathVariable Long id){
        ProjectRecordVO vo = new ProjectRecordVO();
        vo.setId(id);
        projectRecordService.delete(vo);
        return CallResult.success();
    }
}
