package com.touzhijia.repository;

/**
 * Created by chenxl on 2018/3/31.
 */

import java.util.List;


import com.touzhijia.domain.entity.InvestRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvestRecordRepository extends JpaRepository<InvestRecord, Long> {

    List<InvestRecord> findByDebtId(String debtId);

    List<InvestRecord> findByDebtIdOrderByCreateAtDesc(String debtId);

    List<InvestRecord> findByDebtIdAndStatus(String debtId, int status);

}
