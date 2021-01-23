package com.example.yoka.dao;

import com.example.yoka.entity.Project;
import org.apache.ibatis.annotations.Mapper;

import java.io.IOException;
import java.util.List;

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
        Boolean addProject(int id,String project_name,String api_ip,String moudle,String createTime,String updateTime) throws IOException;

    /**
     * 更新项目信息
     * @param project_name
     */
      Boolean updateProject(Project project_name);

    /**
     * 删除项目
     * @param project_name
     */
        Boolean deleteProject(String project_name);

    /**
     * 查询单个项目
     * @param
     */
    public Project queryProject(String project_name);

    /**
     * 查询所有项目
     */
    List<Project> queryAllProject();
}
