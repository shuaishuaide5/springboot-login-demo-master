package com.springboot.service.serviceImpl;

import com.springboot.domain.vo.UserVo;
import com.springboot.repository.UserDao;
import com.springboot.domain.entity.User;
import com.springboot.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.Random;

import static java.lang.Math.random;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    public static void main(String[] args) {

    }
    @Override
    public User loginService(String uname, String password) {
        // 如果账号密码都对则返回登录的用户对象，若有一个错误则返回null
        User user = userDao.findByUnameAndPassword(uname, password);
        // 重要信息置空
        if(user != null){
            user.setPassword("");
        }
        return user;
    }

    @Override
    public User registService(String uname, String password) {
        //当新用户的用户名已存在时
        if(userDao.findByUname(uname)!=null){
            // 无法注册
            return null;
        }else{
            User user = new User();

            user.setPassword(password);
            user.setUname(uname);
            //返回创建好的用户对象(带uid)
            userDao.insert(user);
            User newuser = new User();
            newuser.setPassword(password);
            newuser.setUname(uname);
            if(newuser != null){
                newuser.setPassword("");
            }
            return newuser;
        }
    }
}
