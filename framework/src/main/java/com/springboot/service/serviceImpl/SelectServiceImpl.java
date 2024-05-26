package com.springboot.service.serviceImpl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.springboot.domain.myMethord.Result;
import com.springboot.domain.entity.Words;
import com.springboot.repository.WordsDao;
import com.springboot.service.SelectService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;


@Service
@CrossOrigin
public class SelectServiceImpl extends ServiceImpl<WordsDao,Words> implements SelectService {
    @Override
    public Result selectBook() {
        LambdaQueryWrapper<Words> wrapper = new LambdaQueryWrapper<>();
        wrapper.orderByAsc(Words::getId);
        Page<Words> page1 = new Page<>(1,10);
        page(page1,wrapper);
        List<Words> records = page1.getRecords();
        //List<WordsVo> vs = BeanCopyUtils.copyBeanList(records, WordsVo.class);
        return Result.okResult(records);
    }
}
