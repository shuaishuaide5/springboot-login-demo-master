package com.springboot.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springboot.domain.entity.*;
import com.springboot.repository.UserWordsDao;
import com.springboot.repository.WordsDao;
import com.springboot.service.ReciteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("reciteService")
public class ReciteServiceImpl extends ServiceImpl<WordsDao, Words> implements ReciteService {
    static Integer MAX_WORDS = 4;
    @Resource
    private UserWordsDao userWordsDao;
    @Autowired
    private WordsDao wordsDao;
    @Override
    public Result recite(boolean state, Integer id, Integer uid) {
       /* LambdaUpdateWrapper<Words> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(Words::getId, id%MAX_WORDS+uid*4-4)  // 设置更新条件
                .set(Words::getState, state);  // 设置要更新的字段和值
        wordsDao.update(null, updateWrapper);
        //int tem = Words::getState;
        updateWrapper.eq(Words::getId, id).ne(Words::getState,1) ;//如果没记住
        Words temWord = wordsDao.selectOne(updateWrapper);
        updateWrapper.set(Words::getTimes,temWord.getTimes()+1);
        wordsDao.update(null, updateWrapper);*/

        UserWords newUser = new UserWords();
        newUser.setUserId(uid);
        newUser.setWordId(id);
        userWordsDao.save(newUser);
        System.out.println("ok");
        LambdaUpdateWrapper<Words> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(Words::getId,id).set(Words::isRemember,state);
        wordsDao.update(null, updateWrapper);
        return Result.okResult("修改成功");

    }
}
