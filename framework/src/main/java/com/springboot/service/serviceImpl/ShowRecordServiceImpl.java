package com.springboot.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.springboot.domain.entity.Record;
import com.springboot.domain.myMethord.Result;
import com.springboot.domain.myMethord.RecordMap;
import com.springboot.domain.entity.Words;
import com.springboot.domain.vo.RecordVo;
import com.springboot.repository.RecordDao;
import com.springboot.repository.WordsDao;
import com.springboot.service.ShowRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("ShowRecordService")
public class ShowRecordServiceImpl implements ShowRecordService {
    @Autowired
    private  RecordDao recordDao;
    @Autowired
    private WordsDao wordsDao;
    @Override
    public void record(RecordVo recordVo) {//添加记录
        LambdaUpdateWrapper<Record> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(Record::getId,recordVo.getUid());
        Record temRecord = recordDao.selectOne(updateWrapper);
        String tid;
        if (recordVo.getTOf() == 0) tid = "0";
        else tid = "1";
        if(recordVo.getId()<=9) {
            tid = tid + "0";
        }
        tid = tid + (long) recordVo.getId();
        temRecord.setSum(temRecord.getSum() + tid);
        updateWrapper.set(Record::getSum,temRecord.getSum());
        recordDao.update(null, updateWrapper);
        System.out.println("ok");
        //return null;
    }
    @Override
    public Result show(Integer uid) {//显示记录
        LambdaQueryWrapper<Record> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Record::getId,uid);
        Boolean temb;
        Integer temi;
        List<RecordMap> recordMapList = new ArrayList<>();
        List<Record> temRecord;
        temRecord = recordDao.selectList(queryWrapper);
        for (Record tem : temRecord){
            String str = tem.toString();
            while (!str.isEmpty()) {
                String firstThree = str.substring(0, 3);
                String one = firstThree.substring(0,1);
                if (one == "1") temb = true;
                else temb = false;
                if (firstThree.substring(1, 2).equals("0")) temi = Integer.parseInt(firstThree.substring(1,2)) ;
                else temi = Integer.parseInt(firstThree.substring(1,3)) ;
                LambdaQueryWrapper<Words> queryWrapper2 = new LambdaQueryWrapper<>();
                queryWrapper2.eq(Words::getId,temi);
                Words temwords = wordsDao.selectOne(queryWrapper2);
                recordMapList.add(new RecordMap(temwords.getEnglish(),temb));
                    // 删除前三个字符
                str = str.substring(3);
                System.out.println("Remaining string after deletion: " + str);
            }
        }
        return Result.okResult(recordMapList);
    }
}
