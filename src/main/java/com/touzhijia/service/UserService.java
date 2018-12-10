package com.touzhijia.service;

import com.touzhijia.domain.dto.UserDTO;
import com.touzhijia.domain.entity.LoginToken;
import com.touzhijia.domain.entity.User;
import com.touzhijia.repository.TokenRepository;
import com.touzhijia.repository.UserRepository;
import com.touzhijia.utils.MD5Utils;
import com.touzhijia.utils.StringUtils;
import org.n3r.idworker.Sid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by sugo on 2018/12/9.
 */

@Service
public class UserService {

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
    public Map<String, String> register(String userName, String passWord) throws Exception {
        Map<String, String> map = new HashMap<>();
        if (StringUtils.isEmpty(userName)) {
            map.put("msg", "用户名不能为空");
            return map;
        }

        if (StringUtils.isEmpty(passWord)) {
            map.put("msg", "密码不能为空");
            return map;
        }

        User userResult = userRepository.getByUserName(userName);
        if (userResult != null) {
            map.put("msg", "该用户名已注册");
            return map;
        }

        User user = new User();
        user.setId(sid.nextShort());
        user.setUserName(userName);
        user.setSalt(UUID.randomUUID().toString().substring(0, 5));
        user.setPassWord(MD5Utils.getMD5Str(passWord + user.getSalt()));
        user.setNickName(userName);
        user.setFaceImage("");
        userRepository.save(user);

        UserDTO userDTO = new UserDTO() ;
        BeanUtils.copyProperties(user,userDTO);

        //注册完成后下发token之后自动登录
        String token = addLoginToken(user.getId());
        map.put("token", token);

        return map;

    }

    /**
     * 登录
     *
     * @param userName
     * @param passWord
     * @return
     */
    public Map<String, String> login(String userName, String passWord) throws Exception {
        Map<String, String> map = new HashMap<>();
        if (StringUtils.isEmpty(userName)) {
            map.put("msg", "用户名不能为空");
            return map;
        }

        if (StringUtils.isEmpty(passWord)) {
            map.put("msg", "密码不能为空");
            return map;
        }

        User userResult = userRepository.getByUserName(userName);
        if (userResult == null) {
            map.put("msg", "用户名不存在");
            return map;
        }

        if (!MD5Utils.getMD5Str(passWord + userResult.getSalt()).equals(userResult.getPassWord())) {
            map.put("msg", "密码错误");
            return map;
        }

        String token = addLoginToken(userResult.getId());
        map.put("token", token);
        return map;
    }

    public String addLoginToken(String userId) {
        LoginToken token = new LoginToken();
        token.setUserId(userId);
        Date date = new Date();
        date.setTime(date.getTime() + 30 * 3600 * 1000);
        token.setExpired(date);
        token.setToken(UUID.randomUUID().toString().replaceAll("-", ""));
        tokenRepository.save(token);

        return token.getToken();

    }

}
