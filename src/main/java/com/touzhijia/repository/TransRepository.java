package com.touzhijia.repository;

import com.touzhijia.domain.entity.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

/**
 * Created by chenxl on 2018/4/1.
 */
public interface TransRepository extends JpaRepository<Transfer, String> {

    List<Transfer> findByStatus(int status);

    List<Transfer> findByDebtIdAndStatus(String debtId, int status);

    List<Transfer> findByExpireAtLessThanAndStatus(Date date, int status);
}
