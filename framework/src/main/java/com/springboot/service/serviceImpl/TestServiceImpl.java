package com.springboot.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.springboot.domain.entity.Iftest;
import com.springboot.domain.myMethord.Result;
import com.springboot.domain.entity.Words;
import com.springboot.domain.vo.TestVo;
import com.springboot.repository.IftestDao;
import com.springboot.repository.RecordDao;
import com.springboot.repository.WordsDao;
import com.springboot.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;
import java.util.UUID;

@Service("testService")
public class TestServiceImpl extends ServiceImpl<WordsDao,Words> implements TestService {
    @Autowired
    private RecordDao recordDao;
    @Autowired
    private IftestDao iftestDao;
    @Override
    public Result test(List<Words> wordsList) {
        if (!wordsList.isEmpty())
            wordsList.remove(0);
        if (wordsList.isEmpty()) return Result.okResult("感谢你完成了今天的任务");
        return Result.okResult("还不可以休息哦");
    }



    @Override
    public Result finish(TestVo test1) {
        LambdaUpdateWrapper<Iftest> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(Iftest::getId,test1.getUid()).set(Iftest::getTest,"0");
        iftestDao.update(null,updateWrapper);

        return Result.okResult("TIMEOUT");
    }

    @Override
    public Result iftest(TestVo test1) {
        String sessionId = UUID.randomUUID().toString();


        LambdaUpdateWrapper<Iftest> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(Iftest::getId,test1.getUid()).set(Iftest::getTest,sessionId);
        iftestDao.update(null,updateWrapper);
        return Result.okResult("即将开始",sessionId);
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

    @Override
    public boolean ifTimeOut(Integer uid) {
        LambdaQueryWrapper<Iftest> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Iftest::getId,uid).eq(Iftest::getTest,"0");
        return iftestDao.selectOne(queryWrapper) != null;
    }

}
