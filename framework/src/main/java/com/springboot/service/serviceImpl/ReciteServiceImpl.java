package com.springboot.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springboot.domain.myMethord.Result;
import com.springboot.domain.entity.*;
import com.springboot.repository.UserWordsDao;
import com.springboot.repository.WordsDao;
import com.springboot.service.ReciteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("reciteService")
public class ReciteServiceImpl extends ServiceImpl<WordsDao, Words> implements ReciteService {
    static Integer MAX_WORDS = 4;
    @Resource
    private UserWordsDao userWordsDao;
    @Autowired
    private WordsDao wordsDao;
    @Override
    public Result recite(boolean state, Integer id, Integer uid) {

        LambdaUpdateWrapper<UserWords> updateWrapper1 = new LambdaUpdateWrapper<>();
        updateWrapper1.eq(UserWords::getUserId,uid).eq(UserWords::getWordId,id);
        UserWords temWord = userWordsDao.selectOne(updateWrapper1);
        LambdaUpdateWrapper<Words> updateWrapper = new LambdaUpdateWrapper<>();
        if (temWord != null) {
            updateWrapper1.set(UserWords::getTimes, temWord.getTimes() + 1);
            userWordsDao.update(null,updateWrapper1);
            updateWrapper.eq(Words::getId,id).set(Words::getTestTimes,temWord.getTimes() + 1).set(Words::isRemember,state);
            wordsDao.update(null,updateWrapper);
            return Result.okResult("修改成功");
        }
        UserWords newUser = new UserWords();
        newUser.setUserId(uid);
        newUser.setWordId(id);
        newUser.setTimes(1);
        userWordsDao.insert(newUser);//新建一条数据
        System.out.println("ok");
        updateWrapper.eq(Words::getId,id).set(Words::isRemember,state).set(Words::getTestTimes,1);
        wordsDao.update(null, updateWrapper);
        return Result.okResult("修改成功");

    }
}
