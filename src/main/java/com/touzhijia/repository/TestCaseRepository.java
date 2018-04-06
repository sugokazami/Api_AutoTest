package com.touzhijia.repository;

import com.touzhijia.domain.entity.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by chenxl on 2018/3/1.
 */


public interface TestCaseRepository extends JpaRepository<TestCase,Integer>{

    List<TestCase> getByProjectId(Integer projectId) ;

}
