package com.sugo.controller;


import com.sugo.domain.Result;
import com.sugo.domain.entity.TestProject;
import com.sugo.service.TestProjectService;
import com.sugo.utils.ResultUtils;
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
        return ResultUtils.success(project) ;
    }

    @GetMapping("/test_project/list")
    public Result getTestProjectList(){
        List<TestProject> testProjectList = testProjectService.getTestProjectList();
        return ResultUtils.success(testProjectList) ;
    }

   @GetMapping("/test_project/{id}")
    public Result getTestProject(@PathVariable("id") Integer id){
        TestProject testProject = testProjectService.getTestProject(id);
        return ResultUtils.success(testProject) ;
    }
}
