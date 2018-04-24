package com.touzhijia.repository;

import com.touzhijia.domain.entity.TestRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by chenxl on 2018/4/24.
 */

public interface TestRecordRepository extends JpaRepository<TestRecord,Integer> {

    List<TestRecord> getByCaseId(Integer caseId) ;
}
