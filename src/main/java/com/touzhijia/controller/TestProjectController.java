package com.touzhijia.controller;


import com.touzhijia.domain.Result;
import com.touzhijia.domain.entity.TestProject;
import com.touzhijia.service.TestProjectService;
import com.touzhijia.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by chenxl on 2018/3/12.
 */

@RestController
@RequestMapping("/api")
public class TestProjectController {

    @Autowired
    private TestProjectService testProjectService ;

    @PostMapping("/test_project/add")
    public Result addTestProject(@Valid @RequestBody TestProject testProject){
        TestProject project = testProjectService.saveTestProject(testProject);
        return ResultUtil.success(project) ;
    }

    @GetMapping("/test_project/list")
    public Result getTestProjectList(){
        List<TestProject> testProjectList = testProjectService.getTestProjectList();
        return ResultUtil.success(testProjectList) ;
    }

   @GetMapping("/test_project/{id}")
    public Result getTestProject(@PathVariable("id") Integer id){
        TestProject testProject = testProjectService.getTestProject(id);
        return ResultUtil.success(testProject) ;
    }
}
