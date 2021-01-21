package com.example.yoka.controller;

import com.example.yoka.service.Imp.ProjectImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.logging.Logger;

@Controller
public class ProjectController {

    @Autowired
    ProjectImp projectImp;

    private  static Logger log =  Logger.getLogger(String.valueOf(ProjectController.class));

    @RequestMapping(value = "/addProject", method = RequestMethod.POST)
    @ResponseBody
    public String addProject(@RequestParam(value = "projectName") String projectName,
                             @RequestParam(value = "apiIp") String apiIp,
                             @RequestParam(value = "module") String module) throws IOException {
        log.info("项目："+ projectName + "成功调用新增接口");
        projectImp.addProject(projectName,apiIp,module);
        return "项目成功新增";
    }

}
