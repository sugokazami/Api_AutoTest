package com.touzhijia.repository;

import com.touzhijia.domain.entity.LoginToken;
import com.touzhijia.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by sugo on 2018/12/9.
 */
public interface TokenRepository extends JpaRepository<LoginToken,Integer> {

    LoginToken getByUserName(String userId) ;

}
