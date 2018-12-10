package com.touzhijia.controller;

import com.touzhijia.domain.Result;
import com.touzhijia.domain.entity.User;
import com.touzhijia.service.UserService;
import com.touzhijia.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by sugo on 2018/12/9.
 */

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService ;

    @PostMapping("/register")
    public Result register(@RequestBody User user, HttpServletResponse response) throws Exception {
        System.out.println(user.getUserName());
        Map<String, Object> map = userService.register(user.getUserName(), user.getPassWord());
        if (map.containsKey("token")){
            Cookie cookie = new Cookie("token", (String) map.get("token"));
            cookie.setPath("/");
            response.addCookie(cookie);
            return ResultUtils.success(map) ;
        }else {
            return ResultUtils.success(map) ;
        }
    }

}
