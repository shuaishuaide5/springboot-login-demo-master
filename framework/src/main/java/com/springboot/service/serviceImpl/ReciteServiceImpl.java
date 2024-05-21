package com.springboot.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springboot.domain.entity.Words;
import com.springboot.repository.WordsDao;
import com.springboot.service.ReciteService;
import com.springboot.domain.entity.ResponseResult;
import org.springframework.stereotype.Service;

@Service("reciteService")
public class ReciteServiceImpl extends ServiceImpl<WordsDao, Words> implements ReciteService {
    @Override
    public ResponseResult recite(Integer state,Integer id) {
        LambdaQueryWrapper<Words> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Words::getId, id);

        return null;
    }
}
