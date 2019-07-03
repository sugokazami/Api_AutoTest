package com.sugo.service;

import com.sugo.domain.entity.TestProject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



/**
 * Created by chenxl on 2018/3/12.
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestProjectServiceTest {

    @Autowired
    private TestProjectService testProjectService ;

    @Test
    public void saveTestProject(){
        TestProject testProject = new TestProject();
        testProject.setProjectName("测试项目");
        testProject.setCreateUser("dalia");
        TestProject testProject1 = testProjectService.saveTestProject(testProject);
        System.out.println(testProject1.toString());
    }

}