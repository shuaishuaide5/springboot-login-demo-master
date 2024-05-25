package com.springboot.service;

import com.springboot.domain.Methord.Result;
import com.springboot.domain.entity.Words;
import com.springboot.domain.vo.RecordVo;
import com.springboot.domain.vo.TestVo;

import java.util.List;

public interface TestService {
    Result test(List<Words> wordsList);

    //void record(RecordVo recordVo);
    Result finish(TestVo test1);



    Result iftest(TestVo test1);

    boolean ifCanTest(TestVo test1);

    void reFresh(TestVo test1);

    boolean ifTimeOut(Integer uid);
}
