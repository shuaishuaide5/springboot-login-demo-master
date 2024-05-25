package com.springboot.service;

import com.springboot.domain.Methord.Result;
import com.springboot.domain.vo.RecordVo;

public interface ShowRecordService {
    Result show(Integer uid);
    void record(RecordVo recordVo);
}
