package com.springboot.controller;

import com.springboot.domain.DTO.IntegerListDTO;
import com.springboot.domain.myMethord.Result;
import com.springboot.domain.entity.Words;
import com.springboot.domain.vo.RecordVo;
import com.springboot.domain.vo.TestVo;
import com.springboot.service.ShowRecordService;
import com.springboot.service.TestService;
import com.springboot.utils.ScheduleTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class TestController {
    private Integer uid;
    @Autowired
    private TestService testService;
    @Autowired
    private ShowRecordService showRecordService;
    @Autowired
    private final ScheduleTask scheduleTask = new ScheduleTask();
    private List<Words> wordsList = new ArrayList<>();

   /* @Autowired
    public TestController(ScheduledTask scheduledTask) {
        this.scheduledTask = scheduledTask;
    }*/
    @RequestMapping("/Menu/testStart")//第一次点击测试按钮调用
    private Result testStart(@RequestBody TestVo test1) {
        uid = test1.getUid();
        if(test1.getSessionId() != "") return null;
        return testService.iftest(test1);
    }
    @RequestMapping("/Menu/copyList")//调用一次，将题目列表拷贝一份
    private Result copy(@RequestBody IntegerListDTO integerListDTO) {
        wordsList.add(new Words());
        wordsList.addAll(integerListDTO.getNumbers());
        System.out.println(wordsList+"___________________________________________________________________________________");
        //testService.test(integerListDTO.getNumbers());
        return Result.okResult(wordsList);
    }
    @RequestMapping("/Menu/test")//每一次答题都调用
    private Result test(@RequestBody TestVo test1) {
        //testService.test(test1.getUid(),test1.getTime());
        //return Result.okResult("测试开始");
        return testService.test(wordsList);
    }
    @RequestMapping("/Menu/time")//只调用一次，用于计时，中途离开页面仍然计时
    private void testTime(@RequestBody TestVo test1) {
        AtomicReference<Result> result = new AtomicReference<>();
        scheduleTask.startCountdown((long) (test1.getTime()*60), () -> {
            System.out.println( test1.getTime()*60+" seconds have passed! Performing a task...");
            testService.reFresh(test1);
            result.set(testService.finish(test1));
            wordsList.clear();// 清空列表
        });
    }
    @RequestMapping("/Menu/continue")//离开页面后再进入时自动调用，判断还能不能答题
    private Result ifContinue(@RequestBody TestVo test1) {
        if (testService.ifCanTest(test1)){
            return Result.okResult("NO ACCESS");
        }
        return Result.okResult("继续");
    }
    @RequestMapping("/Menu/returnCopy")//离开页面后再进入时由continue方法的返回值决定是否调用
    private Result returnCopy() {

        return Result.okResult("归还",wordsList);
    }
    @RequestMapping("/Menu/noreturnCopy")//离开页面后再进入时由continue方法的返回值决定是否调用
    private Result noreturnCopy() {
        wordsList.clear();
        return Result.okResult("结束");
    }
    @GetMapping("/Menu/ifTimeOut")//每一次答题都调用，用于测试时间是否耗尽
    private Result ifTimeOut() {
        if (testService.ifTimeOut(uid)) return Result.okResult("TIMEOUT");
        return Result.okResult("TIME EXITS");
    }
    @RequestMapping("/Menu/record")
    private void record(@RequestBody RecordVo recordVo) {
        showRecordService.record(recordVo);
        //return  reciteService.recite(enbook.getState(),enbook.getId(),enbook.getUid());
    }
    @RequestMapping("/Menu/showRecord")
    private Result showRecord(@RequestBody Integer Uid) {

        return showRecordService.show(Uid);
    }
}
