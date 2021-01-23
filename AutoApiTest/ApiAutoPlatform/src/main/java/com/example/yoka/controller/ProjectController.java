package com.example.yoka.controller;

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
    public Boolean addProject(@RequestParam(value = "project_name") String project_name,
                             @RequestParam(value = "apiIp") String apiIp,
                             @RequestParam(value = "module") String module) throws IOException {
        log.info("项目："+ project_name + "成功调用新增接口");
        Boolean res = projectImp.addProject(project_name,apiIp,module);
        return res;
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
    public Boolean updateProject(@RequestParam(value = "apiIp") String apiIp,
                                @RequestParam(value = "module") String module,
                                @RequestParam(value = "project_name") String project_name
    ) throws IOException {
        Boolean res = projectImp.updateProject(project_name,apiIp,module);
        return res;
    }

    /**
     * 查询单个项目
     * @param project_name
     * @return
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/queryProject",method = RequestMethod.POST)
    public Project queryProject(@RequestParam(value = "project_name") String project_name) throws IOException {
        Project project = projectImp.queryProject(project_name);
        return project;
    }

    /**
     * 查询所有项目
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/queryAllProject",method = RequestMethod.POST)
    public String queryAllProject(){
        String projects = null;
        try {
            projects = projectImp.queryAllProject();
        }catch (Exception e){
            e.printStackTrace();
        }

        log.info("-----查询成功-----");
        return projects;
    }

    /**
     * 删除项目
     * @param project_name
     * @return
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/deleteProject",method = RequestMethod.POST)
    public Boolean deleteProject(@RequestParam(value = "project_name") String project_name) throws IOException {
        Boolean res = projectImp.deleteProject(project_name);
        return res;
    }

}
