package com.sugo.service;

import com.sugo.domain.entity.User;

/**
 * Created by sugo on 2018/12/17.
 */
public interface UserService {

    /**
     * 查找用户
     *
     * @param username
     * @return
     */
    User queryUserName(String username);

    /**
     * 保存用户
     *
     * @param user
     */
    void saveUser(User user);

    /**
     * 判断用户名是否存在
     *
     * @param username
     * @return
     */
    boolean queryUserNameIsExists(String username);

}
