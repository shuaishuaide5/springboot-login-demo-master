package com.springboot.service;

import com.springboot.domain.entity.ResponseResult;

public interface SelectService {
    public ResponseResult selectBook(Integer levels);
}
