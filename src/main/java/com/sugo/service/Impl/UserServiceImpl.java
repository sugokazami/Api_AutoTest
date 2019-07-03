package com.sugo.service.Impl;

import com.sugo.domain.dto.UserDTO;
import com.sugo.domain.entity.LoginToken;
import com.sugo.domain.entity.User;
import com.sugo.domain.enums.ResultEnum;
import com.sugo.exception.BusinessException;
import com.sugo.repository.TokenRepository;
import com.sugo.repository.UserRepository;
import com.sugo.service.UserService;
import com.sugo.utils.MD5Utils;
import com.sugo.utils.StringUtils;
import org.n3r.idworker.Sid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.UUID;

/**
 * Created by sugo on 2018/12/9.
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenRepository tokenRepository;

    @Autowired
    private Sid sid;


    /**
     * 用户注册
     *
     * @param userName
     * @param passWord
     * @return
     * @throws Exception
     */
    public UserDTO register(String userName, String passWord) throws Exception {
        //判断用户名和密码必须不为空
        if (StringUtils.isEmpty(userName)) {
            throw new BusinessException(ResultEnum.USERNAME_NOT_NULL);
        }

        if (StringUtils.isEmpty(passWord)) {
            throw new BusinessException(ResultEnum.PASSWORD_NOT_NULL);
        }

        //判断用户是否存在
        if (queryUserNameIsExists(userName)) {
            throw new BusinessException(ResultEnum.USERNAME_EXISTS);
        }

        //保存用户,注册信息
        User user = new User();
        user.setId(sid.nextShort());
        user.setUserName(userName);
        user.setSalt(UUID.randomUUID().toString().substring(0, 5));
        user.setPassWord(MD5Utils.getMD5Str(passWord + user.getSalt()));
        user.setNickName(userName);
        user.setFaceImage("");
        saveUser(user);

        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user, userDTO);

        //注册完成后下发token
        String token = addLoginToken(user.getId());
        userDTO.setToken(token);

        return userDTO;

    }

    /**
     * 登录
     *
     * @param userName
     * @param passWord
     * @return
     */
    public UserDTO login(String userName, String passWord) throws Exception {
        if (StringUtils.isEmpty(userName)) {
            throw new BusinessException(ResultEnum.USERNAME_NOT_NULL);
        }

        if (StringUtils.isEmpty(passWord)) {
            throw new BusinessException(ResultEnum.PASSWORD_NOT_NULL);
        }

        User userResult = queryUserName(userName);
        if (userResult == null) {
            throw new BusinessException(ResultEnum.USERNAME_NOT_EXISTS);
        }

        if (!MD5Utils.getMD5Str(passWord + userResult.getSalt()).equals(userResult.getPassWord())) {
            throw new BusinessException(ResultEnum.PASSWORD_INVALID);
        }

        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(userResult, userDTO);

        //登录完成后下发token
        String token = addLoginToken(userResult.getId());
        userDTO.setToken(token);

        return userDTO;

    }


    public String addLoginToken(String userId) {
        LoginToken token = new LoginToken();
        token.setUserId(userId);
        Date date = new Date();
        date.setTime(date.getTime() + 30 * 60 * 1000);
        token.setExpired(date);
        token.setToken(UUID.randomUUID().toString().replaceAll("-", ""));
        tokenRepository.save(token);

        return token.getToken();

    }

    public void removeLoginToken(String userId) {
        //todo
    }


    @Override
    public boolean queryUserNameIsExists(String username) {
        User result = queryUserName(username);
        return result != null;
    }

    @Override
    public User queryUserName(String username) {
        return userRepository.getByUserName(username);
    }

    @Transactional(Transactional.TxType.REQUIRED)
    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }
}
