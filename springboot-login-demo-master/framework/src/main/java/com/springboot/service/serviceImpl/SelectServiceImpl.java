package com.springboot.service.serviceImpl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.springboot.domain.entity.ResponseResult;
import com.springboot.domain.entity.Words;
import com.springboot.repository.WordsDao;
import com.springboot.service.SelectService;
import com.springboot.domain.vo.WordsVo;
import com.springboot.utils.BeanCopyUtils;
import org.springframework.stereotype.Service;

import java.util.List;




@Service
public class SelectServiceImpl extends ServiceImpl<WordsDao,Words> implements SelectService {
    @Override
    public ResponseResult selectBook(Integer levels) {
        LambdaQueryWrapper<Words> wrapper = new LambdaQueryWrapper<>();
        wrapper.gt(Words::getLevles, levels);
        wrapper.orderByAsc(Words::getId);
        Page<Words> page1 = new Page<>(1,10);
        page(page1,wrapper);
        List<Words> records = page1.getRecords();
        List<WordsVo> vs = BeanCopyUtils.copyBeanList(records, WordsVo.class);
        return ResponseResult.okResult(vs);
    }
}
