package com.sugo.controller;

import com.sugo.domain.Result;
import com.sugo.domain.dto.UserDTO;
import com.sugo.domain.entity.User;
import com.sugo.service.Impl.UserServiceImpl;
import com.sugo.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/log")
    public Result log(User user) throws Exception {
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
