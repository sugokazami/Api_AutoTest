package com.touzhijia.repository;

import java.util.List;


import com.touzhijia.domain.entity.Debt;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;


public interface DebtRepository extends JpaRepository<Debt, String> {

    @Query(value = "SELECT * FROM debt WHERE status = ? AND category_id = ? AND flag = 0 ORDER BY create_at DESC LIMIT 10",nativeQuery = true)
    List<Debt> findByStatusAndCategoryId(int status, int categoryId);


    @Query(value = "SELECT * FROM debt WHERE status = ? AND category_id = ? ORDER BY create_at DESC LIMIT 10",nativeQuery = true)
    List<Debt> findByStatusSixAndCategoryId(int status, int categoryId);

    @Query(value = "SELECT * FROM debt WHERE status = ? AND category_id = ? ORDER BY create_at DESC LIMIT 10",nativeQuery = true)
    List<Debt> findByStatusTenAndCategoryId(int status, int categoryId);


//    @Query(value = "SELECT * FROM debt WHERE status = ? AND category_id = ? AND uid = ? ORDER BY create_at DESC LIMIT 10",nativeQuery = true)
//    List<Debt> findByStatusAndCategoryIdAndUid(int status, int categoryId,String uid);

}
