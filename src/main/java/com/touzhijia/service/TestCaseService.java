package com.touzhijia.service;

import com.touzhijia.domain.entity.TestCase;
import com.touzhijia.repository.TestCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by chenxl on 2018/4/18.
 */

@Service
public class TestCaseService {

    @Autowired
    private TestCaseRepository testCaseRepository;

    /**
     * 保存测试用例
     * @param testCase
     * @return
     */
    public TestCase saveTestCase(TestCase testCase) {
        return testCaseRepository.save(testCase);

    }


    /**
     * 获取所属测试项目的测试用例集
     * @param projectId
     * @return
     */
    public List<TestCase> getByProjectId(Integer projectId){
        return testCaseRepository.getByProjectId(projectId) ;
    }

}
