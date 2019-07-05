package com.sugo.dao;

import com.sugo.domain.entity.LoginToken;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by sugo on 2018/12/9.
 */
public interface TokenRepository extends JpaRepository<LoginToken,Integer> {


}
