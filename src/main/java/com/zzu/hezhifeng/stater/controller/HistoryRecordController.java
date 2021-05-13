package com.zzu.hezhifeng.stater.controller;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.zzu.hezhifeng.common.utils.CallResult;
import com.zzu.hezhifeng.pojo.Param.HistoryRecordParam;
import com.zzu.hezhifeng.pojo.Param.ProjectParam;
import com.zzu.hezhifeng.pojo.Param.ProjectRecordParam;
import com.zzu.hezhifeng.pojo.VO.HistoryRecordVO;
import com.zzu.hezhifeng.pojo.VO.ProjectRecordVO;
import com.zzu.hezhifeng.pojo.VO.ProjectVO;
import com.zzu.hezhifeng.service.history.HistoryRecordService;
import com.zzu.hezhifeng.service.project.ProjectRecordService;
import com.zzu.hezhifeng.service.project.ProjectService;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/accessPlatform/v1/project/record/history")
public class HistoryRecordController {
    @Autowired
    private HistoryRecordService historyRecordService;
    @Autowired
    private ProjectRecordService projectRecordService;
    @Autowired
    private ProjectService projectService;

    public CallResult list(HistoryRecordParam param){
        return CallResult.success();
    }

    public CallResult projectHistoryList(@PathVariable Long id){
        ProjectRecordParam recordParam = new ProjectRecordParam();
        ProjectParam projectParam = new ProjectParam();
        projectParam.setId(id);
        String listenIp = projectService.list(projectParam).get(0).getListenIp();
        ArrayList<HistoryRecordVO> res = Lists.newArrayList();
        recordParam.setProjectId(id);
        ArrayList<ProjectVO> list = projectService.list(projectParam);
        list.forEach(vo -> {
            Long recordId = vo.getId();
            HistoryRecordParam param = new HistoryRecordParam();
            param.setRecordId(recordId);
            ArrayList<HistoryRecordVO> historyRecordVOS = historyRecordService.list(param);
            historyRecordVOS.forEach(historyRecordVO -> {
                String config = historyRecordVO.getConfig();
                if (config != null){
                    ProjectRecordVO recordVO = JSONObject.parseObject(config, ProjectRecordVO.class);
                    historyRecordVO.setTargetIp(recordVO.getTargetIp());
                    historyRecordVO.setTargetPort(recordVO.getTargetPort());
                    historyRecordVO.setListenIp(recordVO.getListenIp());
                    historyRecordVO.setMatchValue(recordVO.getMatchValue());
                    historyRecordVO.setDetail(recordVO.getDetail());
                }
                historyRecordVO.setListenIp(listenIp);
                res.add(historyRecordVO);
            });
        });
        return CallResult.success(res);
    }
}
