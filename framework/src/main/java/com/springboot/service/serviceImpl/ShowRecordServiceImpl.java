package com.springboot.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.springboot.domain.entity.Iftest;
import com.springboot.domain.entity.Record;
import com.springboot.domain.entity.Result;
import com.springboot.repository.RecordDao;
import com.springboot.service.ShowRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ShowRecordService")
public class ShowRecordServiceImpl implements ShowRecordService {
    @Autowired
    private  RecordDao recordDao;
    @Override
    public Result show(Integer uid) {
        LambdaQueryWrapper<Record> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Record::getId,uid);
        List<Record> temWord;
        temWord = recordDao.selectList(queryWrapper);
        return Result.okResult(temWord);
    }
}
