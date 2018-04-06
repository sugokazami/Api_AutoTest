package com.touzhijia.repository;

import com.touzhijia.domain.entity.DebtBorrow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by chenxl on 2018/3/30.
 */
public interface DebtBorrowRepository extends JpaRepository<DebtBorrow, String> {

    @Query(value = "SELECT * FROM debt.debt_borrow WHERE status = ? AND category_id = ? ORDER BY create_date DESC LIMIT 10", nativeQuery = true)
    List<DebtBorrow> findByStatusAndType(int status, int category_id);

    @Query(value = "SELECT * FROM debt.debt_borrow WHERE status = ? AND category_id = ? AND user_name = ? ORDER BY create_date DESC LIMIT 10", nativeQuery = true)
    List<DebtBorrow> findByStatusAndTypeAndUid(int status, int category_id, String uid);

    @Query(value = "SELECT * FROM debt.debt_borrow WHERE status = ? AND category_id = ? ORDER BY create_date DESC LIMIT 10", nativeQuery = true)
    List<DebtBorrow> findByStatusSixAndType(int status, int category_id);

    @Query(value = "SELECT * FROM debt.debt_borrow WHERE status = ? AND category_id = ? ORDER BY create_date DESC LIMIT 10", nativeQuery = true)
    List<DebtBorrow> findByStatusNineAndType(int status, int category_id);
}
