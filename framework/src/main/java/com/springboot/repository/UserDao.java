package com.springboot.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springboot.domain.entity.Record;
import com.springboot.domain.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends BaseMapper<User> {
    /*User findByUname(String uname); //通过用户名uname查找用户，注意要按照JPA的格式使用驼峰命名法
    User findByUnameAndPassword(String uname, String password);//通过用户名uname和密码查找用户*/
}
