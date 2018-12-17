package com.touzhijia.controller;

import com.touzhijia.domain.Result;
import com.touzhijia.domain.dto.UserDTO;
import com.touzhijia.domain.entity.User;
import com.touzhijia.service.Impl.UserServiceImpl;
import com.touzhijia.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by sugo on 2018/12/9.
 */

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/register")
    public Result register(@RequestBody User user, HttpServletResponse response) throws Exception {
        UserDTO userDTO = userService.register(user.getUserName(), user.getPassWord());
        if (userDTO != null) {
            Cookie cookie = new Cookie("token", userDTO.getToken());
            cookie.setPath("/");
            response.addCookie(cookie);
        }
        return ResultUtils.success(userDTO);
    }

    @PostMapping("/login")
    public Result login(@RequestBody User user) throws Exception {
        UserDTO userDTO = userService.login(user.getUserName(), user.getPassWord());
        return ResultUtils.success(userDTO);
    }

    @PostMapping("logout")
    public Result logout(String userId) {
        //将该用户的Token移除
        //todo
        return ResultUtils.success() ;
    }
}
