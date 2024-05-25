package com.springboot.service;

import com.springboot.domain.entity.Result;
import com.springboot.domain.vo.TestVo;

public interface TestService {
    void test(int uid,int time);

    void record(int uid,int id);
    Result finish();



    Result iftest(TestVo test1);

    boolean ifCanTest(TestVo test1);

    void reFresh(TestVo test1);
}
