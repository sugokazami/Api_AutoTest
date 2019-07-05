package com.sugo.dao;

import com.sugo.domain.entity.TestStep;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by chenxl on 2018/3/1.
 */


public interface TestStepRepository extends JpaRepository<TestStep,Integer> {

    List<TestStep> getByCaseId(Integer caseId) ;

}
