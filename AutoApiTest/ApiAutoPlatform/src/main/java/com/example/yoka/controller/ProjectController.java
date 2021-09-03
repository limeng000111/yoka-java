package com.example.yoka.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.yoka.entity.Project;
import com.example.yoka.service.Imp.ProjectImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Controller
public class ProjectController {

    @Autowired
    ProjectImp projectImp;

    private  static Logger log =  Logger.getLogger(String.valueOf(ProjectController.class));

    /**
     * 新增项目
     * @param project_name
     * @param apiIp
     * @param module
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/addProject", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject addProject(@RequestParam(value = "project_name") String project_name,
                                 @RequestParam(value = "apiIp") String apiIp,
                                 @RequestParam(value = "module") String module) throws IOException {
        log.info("项目："+ project_name + "成功调用新增接口");
        return projectImp.addProject(project_name,apiIp,module);
    }

    /**
     * 更新项目
     * @param apiIp
     * @param module
     * @param project_name
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/updateProject",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject updateProject(@RequestParam(value = "apiIp") String apiIp,
                                @RequestParam(value = "module") String module,
                                @RequestParam(value = "project_name") String project_name
    ) throws IOException {
        return projectImp.updateProject(project_name,apiIp,module);
    }

    /**
     * 查询单个项目
     * @param project_name
     * @return
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/queryProject",method = RequestMethod.POST)
    public JSONObject queryProject(@RequestParam(value = "project_name") String project_name) throws IOException {
        return projectImp.queryProject(project_name);
    }

    /**
     * 查询所有项目
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/queryAllProject",method = RequestMethod.GET)
    public JSONObject queryAllProject() throws IOException {
        return projectImp.queryAllProject();
    }

    /**
     * 删除项目
     * @param project_name
     * @return
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/deleteProject",method = RequestMethod.POST)
    public JSONObject deleteProject(@RequestParam(value = "project_name") String project_name) throws IOException {
        return projectImp.deleteProject(project_name);
    }

}
