package com.example.yoka.service.Imp;

import com.alibaba.fastjson.JSONObject;
import com.example.yoka.dao.ApiDao;
import com.example.yoka.entity.Api;
import com.example.yoka.entity.Project;
import com.example.yoka.service.ApiService;
import com.example.yoka.test.MybatisTest;
import com.example.yoka.utils.ResultBuilder;
import com.example.yoka.utils.StatusCode;
import com.example.yoka.utils.TimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.testng.Assert;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

@Slf4j
@Service
public class ApiServiceImp implements ApiService {

    @Autowired
    TimeUtil timeUtil;

    @Autowired
    ProjectImp projectImp;

    @Autowired
    ApiDao apiMapper;

    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

//    @Autowired
//    ResultBuilder resultBuilder;

    public ApiServiceImp() throws IOException {
    }

    /**
     * 新增api接口
     * @param projectName
     * @param moudle
     * @param apiName
     * @param requestMethod
     * @param parameterFormat
     * @param apiRoute
     * @param apiDescription
     * @return
     * @throws IOException
     */
    @Override
    public JSONObject addApi(String projectName, String moudle, String apiName, String requestMethod, String parameterFormat, String apiRoute, String apiDescription) throws IOException {


        //判断该项目是否存在
        try {
            Project project = projectImp.isExistProject(projectName);
            if (project == null){
                log.info("不存在此项目");
                return new ResultBuilder(StatusCode.NO_PROJECT).toJSONObject();
            }else {
                //查询数据库中该项目是否存在该接口
                Api api = isExsitApi(apiName);
                //查询缓存
                redisTemplate.opsForValue().set("test","1111");
                //项目中的该接口已经存在
                if (api != null && api.getMoudle().equals(moudle) && api.getProjectName().equals(projectName)) {
                    log.info("数据已经存在");
                    return new ResultBuilder(StatusCode.EXIST_API).toJSONObject();
                } else {
                    try {
                        //获取当前时间
                        String createTime = timeUtil.getCurrentTime();
                        String updateTime = createTime;
                        //新增api接口
                        SqlSession session = MybatisTest.testMybatis();
                        String statement = "com.example.yoka.dao.ApiDao.addApi";
                        Api apiNew = new Api(1, projectName, moudle, apiName, requestMethod, parameterFormat, apiRoute, apiDescription, createTime, updateTime);
                        log.info("新插入的api信息：{}", apiNew.toString());
                        session.insert(statement, apiNew);
                        session.commit();
                        session.close();
                        log.info("插入api信息成功");
                        return new ResultBuilder("插入数据成功",StatusCode.SUCCESS).toJSONObject();
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.info("插入新增api失败：{}", apiName);
                    }

                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        log.info("{}api新增失败",projectName);
        return new ResultBuilder("接口新增失败",StatusCode.ADD_API_FAILED).toJSONObject();
    }



    @Override
    public JSONObject deleteApi(String projectName,String apiName) throws IOException {
        //查询项目是否存在
        Project project = projectImp.isExistProject(projectName);
        log.info("查询到数据库数据："+ project.toString());
        if (project != null){
            if (isExsitApi(apiName) != null){
                SqlSession session = MybatisTest.testMybatis();
                try {
                    String statement = "com.example.yoka.dao.ApiDao.deleteApi";
                    session.delete(statement, apiName);
                    return new ResultBuilder(StatusCode.SUCCESS).toJSONObject();
                }catch (Exception e){
                    e.printStackTrace();
//                    session.rollback();
//                    return new ResultBuilder(StatusCode.DELETE_PROJECT_FAILED).toJSONObject();
                }finally {
                    session.commit();
                    session.close();
                }
            }

        }
        return new ResultBuilder(StatusCode.DELETE_PROJECT_FAILED).toJSONObject();
    }

    @Override
    public JSONObject updateApi(String projectName, String moudle, String apiName, String requestMethod, String parameterFormat, String apiRoute, String apiDescription) throws IOException {
        //查询项目是否存在
        Project project = projectImp.isExistProject(projectName);
        log.info("查询到数据库数据："+ project.toString());
        if (project != null){
            //查询接口是否存在
            Api api= isExsitApi(apiName);
            if (api != null){
                log.info("接口数据："+ api.toString());
                SqlSession session = MybatisTest.testMybatis();
                String statement = "com.example.yoka.dao.ApiDao.updateApi";
                api.setMoudle(moudle);
                api.setRequestMethod(requestMethod);
                api.setParameterFormat(parameterFormat);
                api.setApiRoute(apiRoute);
                api.setApiDescription(apiDescription);
                String currentTime = timeUtil.getCurrentTime();
                api.setUpdateTime(currentTime);
                log.info("更新后的接口数据："+ api.toString());
                session.update(statement,api);
                session.commit();
                session.close();
                return new ResultBuilder(StatusCode.SUCCESS).toJSONObject();
            }
        }
        return new ResultBuilder(StatusCode.UPDATE_API_FAILED).toJSONObject();
    }


    /**
     * 根据apiName查询api信息返回给前端
     * @param apiName
     * @return
     */
    @Override
    public JSONObject queryApi(String apiName) {
        try {
            SqlSession session = MybatisTest.testMybatis();
            String statement = "com.example.yoka.dao.ApiDao.queryApi";
            Api api = session.selectOne(statement, apiName);
            log.info("查询的api信息：{}",api.getApiName());
            //强行插入redis
            redisTemplate.opsForValue().set("test","1111");
            redisTemplate.opsForValue().set("apiInfo",api.toString());

            String res = (String) redisTemplate.opsForValue().get("test");
            log.info("从redis获取到数据："+res);
            return new ResultBuilder(api,StatusCode.SUCCESS).toJSONObject();
        }catch (Exception e){
            log.info("从数据库中查询api无结果：{}",e.getMessage());
        }
        return new ResultBuilder(StatusCode.QUERY_SINGLE_API_FAILED).toJSONObject();
    }

    /**
     * 查询数据库是否存在该api
     * @param apiName
     * @return
     */
    public Api isExsitApi(String apiName){
        try {
            SqlSession session = MybatisTest.testMybatis();
            String statement = "com.example.yoka.dao.ApiDao.queryApi";
            Api api = session.selectOne(statement, apiName);
            return api;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    //查询所有api接口
    @Override
    public JSONObject queryAllApi() throws IOException {
        SqlSession session = MybatisTest.testMybatis();
        try {
            String statement = "com.example.yoka.dao.ApiDao.queryAllApi";
//            List<Api> apiList = Collections.singletonList((Api) session.selectList(statement));
            List<Api> apiList = session.selectList(statement);
            ResultBuilder res = new ResultBuilder(apiList, StatusCode.SUCCESS);
            log.info("查询的api信息：{}",apiList);
            log.info("返回前段的数据为：{}",res.toJSONObject());
            return res.toJSONObject();

        }catch (Exception e){
            log.info("从数据库中查询api无结果：{}",e.getMessage());
        }
        return new ResultBuilder(StatusCode.QUERY_ALL_API_FAILED).toJSONObject();
    }

//    public Boolean assertData(){
//        Assert.
//        return null;
//    }
}
