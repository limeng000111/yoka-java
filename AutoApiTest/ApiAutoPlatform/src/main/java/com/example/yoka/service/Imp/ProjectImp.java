package com.example.yoka.service.Imp;

/**
 * author:limeng
 * Date:2021/1/20
 */

import com.example.yoka.entity.Project;
import com.example.yoka.service.ProjectInter;
import com.example.yoka.test.MybatisTest;
import com.example.yoka.utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.logging.Logger;

@Service
public class ProjectImp implements ProjectInter {

    @Autowired
    Project project;

    @Autowired
    TimeUtil timeUtil;

    private  static Logger log = (Logger) Logger.getLogger(String.valueOf(ProjectImp.class));
    @Override
    public void addProject(String project_name, String api_ip, String moudle) throws IOException {
        try {
            String statement = "com.example.yoka.dao.ProjectDao.addProject";
            String createTime = timeUtil.getCurrentTime();
            String updateTime = createTime;
            //创建project对象
            Project projectNew = new Project(1, project_name, api_ip, moudle, createTime, updateTime);
            //数据库中插入项目数据
            MybatisTest.testMybatis().insert(statement,projectNew);
            log.info("插入项目："+project_name+("成功"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateProject(String project_name, String api_ip, String moudle, String createTime, String updateTime) {

    }

    @Override
    public void deleteProject(String project_name) {

    }

    @Override
    public void queryProject(String project_name) {

    }

    @Override
    public void queryAllProject() {

    }
}
