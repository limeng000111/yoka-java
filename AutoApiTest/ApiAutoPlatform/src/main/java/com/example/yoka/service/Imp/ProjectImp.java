package com.example.yoka.service.Imp;

/**
 * author:JACK
 * Date:2021/1/20
 */

import com.example.yoka.entity.Project;
import com.example.yoka.service.ProjectInter;
import com.example.yoka.test.MybatisTest;
import com.example.yoka.utils.TimeUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

@Service
public class ProjectImp implements ProjectInter {

    @Autowired
    TimeUtil timeUtil;


    SqlSession session = MybatisTest.testMybatis();

    private  static Logger log = (Logger) Logger.getLogger(String.valueOf(ProjectImp.class));

    public ProjectImp() throws IOException {
    }

    /**
     * 新增项目
     * @param project_name
     * @param api_ip
     * @param moudle
     * @throws IOException
     */
    @Override
    public void addProject(String project_name, String api_ip, String moudle) throws IOException {
        try {
            String statement = "com.example.yoka.dao.ProjectDao.addProject";
            String createTime = timeUtil.getCurrentTime();
            String updateTime = createTime;
            //创建project对象
            Project projectNew = new Project(1, project_name, api_ip, moudle, createTime, updateTime);
            try {
                //数据库中插入项目数据
                log.info("即将插入项目信息："+projectNew.toString());
                session.insert(statement,projectNew);
                log.info("插入项目数据结束");
            }finally {
                session.commit();
                session.close();
            }
            log.info("插入项目："+project_name+("成功"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 更新项目
     * @param project_name
     * @param api_ip
     * @param moudle
     *
     */
    @Override
    public void updateProject(String project_name, String api_ip, String moudle) {
        //判断项目名称是否存在
        if (project_name != null && !project_name.equals("")){
            ArrayList<Project> list = new ArrayList<>();
            String statement = "com.example.yoka.dao.ProjectDao.queryProject";
            //先查询数据库是否存在项目名
             Project project= session.selectOne(statement, project_name);
             list.add(project);
             if (list.size() == 1){
                 log.info("准备修改项目："+project_name+"的信息");
                 //获取当前时间
                 String currentTime = timeUtil.getCurrentTime();
                 //对项目信息进行修改
                 project.setApi_ip(api_ip);
                 project.setMoudle(moudle);
                 project.setUpdate_time(currentTime);
                 String queryStatement = "com.example.yoka.dao.ProjectDao.updateProject";
                 session.update(queryStatement,project);
             }
        }
        //判断传入字段是否完整
        //更新时间
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
