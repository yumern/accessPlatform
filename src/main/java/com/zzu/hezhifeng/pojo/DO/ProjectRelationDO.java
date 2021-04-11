package com.zzu.hezhifeng.pojo.DO;

import com.zzu.hezhifeng.common.base.pojo.BaseDO;

import java.util.Date;

/**
 * 用户-项目关联实体
 */
public class ProjectRelationDO extends BaseDO {
    /**
     * 项目空间id，用以区分不同用户的项目空间
     */
    private String code;
    /**
     * 项目id
     */
    private String projectId;
    /**
     * 项目描述
     */
    private String projectDesc;
    /**
     * 项目中字段的数量
     */
    private Integer projectNum;
    /**
     * 记录修改时间
     */
    Date gmdModified;
    /**
     * 来源ip
     */
    private String sourceIp;
    /**
     * 来源端口
     */
    private String sourcePort;
    /**
     * 目标ip
     */
    private String targetIp;
    /**
     * 目标端口
     */
    private String targetPort;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getGmdModified() {
        return gmdModified;
    }

    public void setGmdModified(Date gmdModified) {
        this.gmdModified = gmdModified;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectDesc() {
        return projectDesc;
    }

    public void setProjectDesc(String projectDesc) {
        this.projectDesc = projectDesc;
    }

    public Integer getProjectNum() {
        return projectNum;
    }

    public void setProjectNum(Integer projectNum) {
        this.projectNum = projectNum;
    }

    public String getSourceIp() {
        return sourceIp;
    }

    public void setSourceIp(String sourceIp) {
        this.sourceIp = sourceIp;
    }

    public String getSourcePort() {
        return sourcePort;
    }

    public void setSourcePort(String sourcePort) {
        this.sourcePort = sourcePort;
    }

    public String getTargetIp() {
        return targetIp;
    }

    public void setTargetIp(String targetIp) {
        this.targetIp = targetIp;
    }

    public String getTargetPort() {
        return targetPort;
    }

    public void setTargetPort(String targetPort) {
        this.targetPort = targetPort;
    }

    @Override
    public String toString() {
        return "projectRelation{" +
                ", code='" + code + '\'' +
                ", projectId='" + projectId + '\'' +
                ", projectDesc='" + projectDesc + '\'' +
                ", projectNum=" + projectNum +
                ", sourceIp='" + sourceIp + '\'' +
                ", sourcePort='" + sourcePort + '\'' +
                ", targetIp='" + targetIp + '\'' +
                ", targetPort='" + targetPort + '\'' +
                '}';
    }
}
