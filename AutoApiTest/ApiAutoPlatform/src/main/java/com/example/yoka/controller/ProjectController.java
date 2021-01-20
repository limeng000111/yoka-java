package com.example.yoka.controller;

import com.example.yoka.service.Imp.ProjectImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.logging.Logger;

@Controller
public class ProjectController {

    @Autowired
    ProjectImp projectImp;

    private  static Logger log = (Logger) Logger.getLogger(String.valueOf(ProjectController.class));

    @ResponseBody
    @RequestMapping(value = "/addProject",method = RequestMethod.GET)
    public String addProject(@RequestParam(value = "project_name") String project_name,
                             @RequestParam(value = "api_ip") String api_ip,
                             @RequestParam(value = "moudle") String moudle) throws IOException {
        log.info("项目："+ project_name + "成功调用新增接口");
        projectImp.addProject(project_name,api_ip,moudle);
        return "项目成功新增";
    }

}
