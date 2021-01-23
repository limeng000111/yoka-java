package com.example.yoka.service.Imp;

/**
 * author:JACK
 * Date:2021/1/20
 */

import com.alibaba.fastjson.JSONObject;
import com.example.yoka.dao.ProjectDao;
import com.example.yoka.entity.Project;
import com.example.yoka.service.ProjectInter;
import com.example.yoka.test.MybatisTest;
import com.example.yoka.utils.ResultBuilder;
import com.example.yoka.utils.StatusCode;
import com.example.yoka.utils.TimeUtil;
import lombok.NoArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
    public Boolean addProject(String project_name, String api_ip, String moudle) throws IOException {
        //查询数据库中是否存在该项目
        Project res = queryProject(project_name);
        if (res != null){
            return false;
        }else {
            try {
                String statement = "com.example.yoka.dao.ProjectDao.addProject";
                String createTime = timeUtil.getCurrentTime();
                String updateTime = createTime;
                //创建project对象
                Project projectNew = new Project(1,project_name, api_ip, moudle, createTime, updateTime);
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
        return true;

    }

    /**
     * 更新项目
     * @param project_name
     * @param api_ip
     * @param moudle
     *
     */
    @Override
    public Boolean updateProject(String project_name, String api_ip, String moudle) throws IOException {
        SqlSession session = MybatisTest.testMybatis();
        //判断项目名称是否存在
        if (project_name != null && !project_name.equals("")){
            log.info("前端传参为："+project_name+"---"+api_ip+"---"+moudle);
            Project project1 = queryProject(project_name);
             if (project1 != null && !project1.equals("")){
                 try {
                     //获取当前时间
                     String currentTime = timeUtil.getCurrentTime();
                     //对项目信息进行修改
                     log.info("moudle的信息为："+moudle);
                     project1.setMoudle(moudle);
                     log.info("修改后的moudle值："+project1.getMoudle());
                     project1.setApi_ip(api_ip);
                     project1.setUpdate_time(currentTime);
                     String queryStatement = "com.example.yoka.dao.ProjectDao.updateProject";
                     session.update(queryStatement,project1);
                     log.info("update数据成功，项目名称为："+project_name);
                 }finally {
                     session.commit();
                     session.close();
                     return true;
                 }

             }else {
                 return false;
             }
        }
        return false;
        //判断传入字段是否完整
        //更新时间
    }

    @Override
    public Boolean deleteProject(String project_name) throws IOException {
        Project project = queryProject(project_name);
        if (project != null){
            SqlSession session = MybatisTest.testMybatis();
            String queryStatement = "com.example.yoka.dao.ProjectDao.deleteProject";
            session.delete(queryStatement,project_name);
            session.commit();
            session.close();
            return true;
        }
        return false;
    }

    /**
     * 根据项目名查询项目信息
     * @param project_name
     * @return
     * @throws IOException
     */
    @Override
    public Project queryProject(String project_name) throws IOException {
        Project project = null;
        SqlSession session = MybatisTest.testMybatis();
        String statement = "com.example.yoka.dao.ProjectDao.queryProject";
        ProjectDao mapper = session.getMapper(ProjectDao.class);
        Project res = session.selectOne(statement, project_name);
//        log.info("根据项目名成功查询出结果："+res.toString());
        return res;
    }

    /**
     * 查询所有的项目数据
     * @return
     * @throws IOException
     */
    @Override
    public String queryAllProject() throws IOException {
        SqlSession session = MybatisTest.testMybatis();
        String statement = "com.example.yoka.dao.ProjectDao.queryAllProject";
        List<Project> list = session.selectList(statement);
        log.info("-------res------:"+ list);
        ArrayList<Object> res = new ArrayList<>();
        JSONObject jsonObject = new JSONObject();
        log.info("查询list："+list);
        int num = list.size();
        log.info("从数据库中查到："+num+"条数据");
        for (int i = 0;i < num;i++){
            log.info("准备加入到list中："+list.get(i));
            res.add(list.get(i));
        }
        log.info("-------"+res);
        jsonObject.put("queryRes",res);
        session.commit();
        session.close();
        ResultBuilder<JSONObject> tResultBuilder = new ResultBuilder<>(jsonObject, StatusCode.SUCCESS);
        log.info(tResultBuilder.toString());
        return tResultBuilder.toString();
    }
}
