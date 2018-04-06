package com.touzhijia.repository;

/**
 * Created by chenxl on 2018/3/31.
 */

import com.touzhijia.domain.entity.Invest;
import org.springframework.data.jpa.repository.JpaRepository;



import java.util.List;


public interface InvestRepository extends JpaRepository<Invest, String> {

    List<Invest> findByDebtId(String debtId);

    List<Invest> findByRelationId(String relationId) ;

    List<Invest> findByRelationIdOrderByCreateAtDesc(String relationId) ;

    List<Invest> findByDebtIdAndStatus(String debtId, int status);

//    @Query("select sum(effectedAmount) from Invest where uid = ? and relationId = ?")
//    BigDecimal findTotalAmount(String uid, String debtId);


}
