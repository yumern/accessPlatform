package com.zzu.hezhifeng.pojo.Param;

import com.zzu.hezhifeng.common.base.pojo.BaseParam;

import java.util.Date;

/**
 * 项目详情实体
 */
public class ProjectDetailsParam extends BaseParam {
    /**
     * 隶属项目Id
     */
    private String projectId;
    /**
     * 项目名称
     */
    private String projectName;
    /**
     * 记录修改时间
     */
    Date gmdModified;
    /**
     * key值
     */
    private String key;
    /**
     * value值
     */
    private String value;


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

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "projectDetails{" +
                ", projectId='" + projectId + '\'' +
                ", projectName='" + projectName + '\'' +
                ", key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
