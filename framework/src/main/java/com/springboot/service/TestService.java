package com.springboot.service;

import com.springboot.domain.entity.Result;

public interface TestService {
    Result test(int uid);

    Result record(int uid,int id);
}
