package com.springboot.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.springboot.domain.entity.Iftest;
import com.springboot.domain.entity.Record;
import com.springboot.domain.entity.Result;
import com.springboot.domain.entity.Words;
import com.springboot.domain.vo.TestVo;
import com.springboot.repository.IftestDao;
import com.springboot.repository.RecordDao;
import com.springboot.repository.WordsDao;
import com.springboot.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.time.Instant;
import java.util.UUID;

@Service("testService")
public class TestServiceImpl extends ServiceImpl<WordsDao,Words> implements TestService {
    @Autowired
    private RecordDao recordDao;
    @Autowired
    private IftestDao iftestDao;
    @Override
    public void test(int uid,int time) {
        Instant now = Instant.now();
        LambdaUpdateWrapper<Record> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(Record::getId,uid);
        updateWrapper.set(Record::getTime,now);
        recordDao.update(null, updateWrapper);

    }

    @Override
    public void record(int uid,int id) {
        LambdaUpdateWrapper<Record> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(Record::getId,uid);
        Record temRecord = recordDao.selectOne(updateWrapper);
        String tid ="";
        if(id<=9) {
            tid = "0";
        }
        tid = tid + (long) id;
        temRecord.setSum(temRecord.getSum() + tid);
        updateWrapper.set(Record::getSum,temRecord.getSum());
        recordDao.update(null, updateWrapper);
        System.out.println("ok");
        //return null;
    }

    @Override
    public Result finish() {
        return Result.okResult("TIMEOUT");
    }

    @Override
    public Result iftest(TestVo test1) {
        String sessionId = UUID.randomUUID().toString();


        LambdaUpdateWrapper<Iftest> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(Iftest::getId,test1.getUid()).set(Iftest::getTest,sessionId);
        iftestDao.update(null,updateWrapper);
        return Result.okResult(sessionId);
    }

    @Override
    public boolean ifCanTest(TestVo test1) {//用于判断退出页面后能否再次答题，即是否为不同的用户
        LambdaQueryWrapper<Iftest> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Iftest::getId,test1.getUid()).eq(Iftest::getTest,test1.getSessionId());
        Iftest temWord;
        temWord = iftestDao.selectOne(queryWrapper);
        return temWord==null;
    }

    @Override
    public void reFresh(TestVo test1) {
        LambdaUpdateWrapper<Iftest> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(Iftest::getId,test1.getUid()).set(Iftest::getTest,"0");
    }

}
