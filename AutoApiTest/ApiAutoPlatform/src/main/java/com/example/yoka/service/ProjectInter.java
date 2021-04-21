package com.example.yoka.service;

import com.alibaba.fastjson.JSONObject;
import com.example.yoka.entity.Project;
import org.apache.ibatis.annotations.Mapper;

import java.io.IOException;
import java.util.List;


/**
 * author:JACK
 * date:2021/1/20
 */
@Mapper
public interface ProjectInter {
    /**
     * 新增项目
     * @param project_name
     * @param api_ip
     * @param moudle
     */
    JSONObject addProject(String project_name, String api_ip, String moudle) throws IOException;

    /**
     * 修改项目
     * @param project_name
     * @param api_ip
     * @param moudle
     */
    JSONObject updateProject(String project_name,String api_ip,String moudle) throws IOException;

    /**
     * 删除项目
     * @param project_name
     */
    JSONObject deleteProject(String project_name) throws IOException;

    /**
     * 查询单个项目
     * @param project_name
     */
    JSONObject queryProject(String project_name) throws IOException;

    /**
     * 查询所有项目
     */
    JSONObject queryAllProject() throws IOException;

    //根据模块进行查询
    Project  queryByMoudle(String moudle) throws IOException;
}
