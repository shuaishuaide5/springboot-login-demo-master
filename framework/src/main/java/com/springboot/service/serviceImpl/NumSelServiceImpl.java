package com.springboot.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springboot.domain.entity.ResponseResult;
import com.springboot.domain.entity.Result;
import com.springboot.domain.entity.Words;
import com.springboot.domain.vo.WordsVo;
import com.springboot.repository.WordsDao;
import com.springboot.service.NumSelService;
import com.springboot.utils.BeanCopyUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service("numSelService")
public class NumSelServiceImpl extends ServiceImpl<WordsDao, Words> implements NumSelService {
    @Override
    public Result selectNum(Integer number) {
        Random r = new Random();
        int i = r.nextInt(40);    //返回一个随机整
        LambdaQueryWrapper<Words> wrapper = new LambdaQueryWrapper<>();
        wrapper.between(Words::getId, i,i+number);
        wrapper.orderByAsc(Words::getId);
        Page<Words> page1 = new Page<>(1,10);
        page(page1,wrapper);
        List<Words> records = page1.getRecords();
        List<WordsVo> vs = BeanCopyUtils.copyBeanList(records, WordsVo.class);
        return Result.okResult(vs);

    }
}
