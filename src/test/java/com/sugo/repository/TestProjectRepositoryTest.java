package com.sugo.repository;

import com.sugo.domain.entity.TestProject;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by chenxl on 2018/3/1.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class TestProjectRepositoryTest {

    @Autowired
    private TestProjectRepository testProjectRepository ;

    @Test
    public void saveProject() throws Exception {
        TestProject testProject01 = new TestProject();
        testProject01.setProjectName("接口测试任务");
        testProject01.setCreateUser("chenxl");
        TestProject save = testProjectRepository.save(testProject01);
        System.out.println(save);
    }


    @Test
    public void getByProjectName() throws Exception {
        TestProject testProject = testProjectRepository.findOne(1);
        assertEquals("接口测试任务",testProject.getProjectName());
    }

    @Test
    public void getByCreateUser() throws Exception {
        List<TestProject> list = testProjectRepository.getByCreateUser("chenxl");
        log.info("TestProject:{}",list);
        assertNotEquals(0,list.size());
    }

}