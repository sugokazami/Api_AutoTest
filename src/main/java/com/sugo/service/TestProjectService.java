package com.sugo.service;


import com.sugo.domain.entity.TestProject;
import com.sugo.dao.TestProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by chenxl on 2018/3/12.
 */

@Service
public class TestProjectService {

    @Autowired
    private TestProjectRepository testProjectRepository ;


    /**
     * 保存测试项目
     * @param testProject
     * @return
     */
    public TestProject saveTestProject(TestProject testProject){
        return testProjectRepository.save(testProject);
    }

    /**
     * 查询所有的测试项目
     * @return
     */
    public List<TestProject> getTestProjectList(){
        return testProjectRepository.findAll() ;
    }

    /**
     * 通过id查询单个测试项目
     * @param id
     * @return
     */
    public TestProject getTestProject(Integer id){
        return testProjectRepository.findOne(id) ;
    }
}
