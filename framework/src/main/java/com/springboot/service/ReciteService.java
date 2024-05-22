package com.springboot.service;

import com.springboot.domain.entity.ResponseResult;

public interface ReciteService {
    ResponseResult recite(Integer state,Integer id,Integer uid);
}
