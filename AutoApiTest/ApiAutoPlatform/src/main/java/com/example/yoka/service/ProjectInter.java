package com.example.yoka.service;

import org.apache.ibatis.annotations.Mapper;

import java.io.IOException;


/**
 * author:JACK
 * date:2021/1/20
 */

public interface ProjectInter {
    /**
     * 新增项目
     * @param project_name
     * @param api_ip
     * @param moudle
     */
    void addProject(String project_name,String api_ip,String moudle) throws IOException;

    /**
     * 修改项目
     * @param project_name
     * @param api_ip
     * @param moudle
     * @param createTime
     * @param updateTime
     */
    void updateProject(String project_name,String api_ip,String moudle,String createTime,String updateTime);

    /**
     * 删除项目
     * @param project_name
     */
    void deleteProject(String project_name);

    /**
     * 查询单个项目
     * @param project_name
     */
    void queryProject(String project_name);

    /**
     * 查询所有项目
     */
    void queryAllProject();
}
