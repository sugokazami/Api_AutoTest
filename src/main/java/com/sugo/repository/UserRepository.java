package com.sugo.repository;

import com.sugo.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by sugo on 2018/12/9.
 */
public interface UserRepository extends JpaRepository<User,String> {

        User getByUserName(String userName) ;

}
