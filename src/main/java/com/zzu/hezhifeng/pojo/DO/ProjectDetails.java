package com.zzu.hezhifeng.pojo.DO;

import java.util.Date;

/**
 * 项目详情实体
 */
public class ProjectDetails {
    /**
     * 自增主键
     */
    private Long id;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectId() {
        return projectId;
    }

    public Date getGmdModified() {
        return gmdModified;
    }

    public void setGmdModified(Date gmdModified) {
        this.gmdModified = gmdModified;
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
                "id=" + id +
                ", projectId='" + projectId + '\'' +
                ", projectName='" + projectName + '\'' +
                ", key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
