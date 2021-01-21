package com.example.yoka.dao;

import com.example.yoka.entity.Project;
import org.apache.ibatis.annotations.Mapper;

import java.io.IOException;

/**
 * Date:2021/1/20
 * author:JACK
 */

public interface ProjectDao {
    /**
     * 新增项目
     * @param project_name
     * @param api_ip
     * @param moudle
     * @param createTime
     * @param updateTime
     */
    void addProject(int id,String project_name,String api_ip,String moudle,String createTime,String updateTime) throws IOException;

    /**
     * 更新项目信息
     * @param project
     */
    void updateProject(Project project);

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
