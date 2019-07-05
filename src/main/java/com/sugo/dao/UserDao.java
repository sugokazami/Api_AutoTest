package com.sugo.dao;

import com.sugo.domain.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {

    User getByUserName(String username);

    Integer insertUser(User user);

}
