package com.zzu.hezhifeng.stater.controller;

import com.zzu.hezhifeng.common.utils.CallResult;
import com.zzu.hezhifeng.pojo.Param.ProjectParam;
import com.zzu.hezhifeng.pojo.VO.ProjectVO;
import com.zzu.hezhifeng.service.project.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/accessPlatform/v1/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @RequestMapping(
            method = RequestMethod.GET
    )
    public CallResult list(ProjectParam param){
        return CallResult.success(projectService.list(param));
    }

    @RequestMapping(
            method = RequestMethod.GET,
            params = "/{id}"
    )
    public CallResult detail(@PathVariable Long id){
        ProjectParam param = new ProjectParam();
        param.setId(id);
        ProjectVO projectVO = projectService.find(param).get();
        return CallResult.success(projectVO);
    }

    @RequestMapping(
            method = RequestMethod.PUT,
            params = "/delete/{id}"
    )
    public CallResult update(@PathVariable Long id, @RequestBody ProjectVO vo){
        vo.setId(id);
        vo.setGmtModified(new Date());
        projectService.update(vo);
        return CallResult.success();
    }

    @RequestMapping(
            method = RequestMethod.DELETE,
            params = "/delete/{id}"
    )
    public CallResult delete(@PathVariable Long id){
        ProjectVO vo = new ProjectVO();
        vo.setId(id);
        projectService.delete(vo);
        return CallResult.success();
    }

    @RequestMapping(
            method = RequestMethod.POST
    )
    public CallResult insert(@RequestBody ProjectVO projectVO){
        Long insert = this.projectService.insert(projectVO);
        return CallResult.success(insert);
    }
}
