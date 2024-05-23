package com.springboot.controller;

import com.springboot.domain.entity.User;
import com.springboot.service.UserService;
import com.springboot.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("/login")//@RequestParam String uname, @RequestParam String password
    public Result<User> loginController(@RequestBody User user){
        User user2 = userService.loginService(user.getUname(), user.getPassword());
        if(user2!=null){
            return Result.success(user,"登录成功！");
        }else{
            return Result.error("123","账号或密码错误！");
        }
    }

    @PostMapping("/register")
    public Result<User> registController(@RequestBody User newUser){
        User user = userService.registService(newUser);
        if(user!=null){
            return Result.success(user,"注册成功！");
        }else{
            return Result.error("456","用户名已存在！");
        }
    }
}
