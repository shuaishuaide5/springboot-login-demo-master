package com.springboot.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springboot.domain.entity.Record;
import com.springboot.domain.entity.Result;
import com.springboot.domain.entity.Words;
import com.springboot.domain.vo.WordsVo;
import com.springboot.repository.RecordDao;
import com.springboot.repository.WordsDao;
import com.springboot.service.TestService;
import com.springboot.utils.BeanCopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
@Service("testService")
public class TestServiceImpl extends ServiceImpl<WordsDao,Words> implements TestService {
    @Autowired
    private RecordDao recordDao;
    @Override
    public Result test(int uid) {

        return null;
    }

    @Override
    public Result record(int uid,int id) {
        LambdaUpdateWrapper<Record> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(Record::getId,uid).eq(Record::getTime,null);
        Record temRecord = recordDao.selectOne(updateWrapper);
        String tid = String.valueOf((long) id);
        temRecord.setSum(temRecord.getSum() + tid);
        updateWrapper.set(Record::getSum,temRecord.getSum());
        System.out.println("ok");
        return null;
    }
}
