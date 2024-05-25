package com.springboot.controller;

import com.springboot.domain.Methord.Result;
import com.springboot.domain.vo.RecordVo;
import com.springboot.domain.vo.TestVo;
import com.springboot.service.ShowRecordService;
import com.springboot.service.TestService;
import com.springboot.utils.ScheduleTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

   /* @Autowired
    public TestController(ScheduledTask scheduledTask) {
        this.scheduledTask = scheduledTask;
    }*/
    @RequestMapping("/Menu/testStart")//第一次点击测试按钮调用
    private Result testStart(@RequestBody TestVo test1) {
        if(test1.getSessionId() != "") return null;
        return testService.iftest(test1);
    }

    @RequestMapping("/Menu/test")//只调用一次，用于计时，中途离开页面仍然计时
    private Result test(@RequestBody TestVo test1) {
        uid = test1.getUid();
        AtomicReference<Result> result = new AtomicReference<>();
        testService.test(test1.getUid(),test1.getTime());
        scheduleTask.startCountdown((long) (test1.getTime()), () -> {
            System.out.println( test1.getTime()*60+" seconds have passed! Performing a task...");
            testService.reFresh(test1);
            result.set(testService.finish(test1));// 在这里执行任务逻辑

        });
        return Result.okResult("测试开始");
    }
    @RequestMapping("/Menu/continue")//离开页面后再进入时自动调用
    private Result ifContinue(@RequestBody TestVo test1) {
        if (testService.ifCanTest(test1)){
            return Result.okResult("NO ACCESS");
        }
        return null;
    }
    @RequestMapping("/Menu/ifTimeOut")
    private Result ifTimeOut() {
        if (testService.ifTimeOut(uid)) return Result.okResult("TIMEOUT");
        return null;
    }
    @RequestMapping("/Menu/record")
    private void record(@RequestBody RecordVo recordVo) {
        testService.record(recordVo);
        //return  reciteService.recite(enbook.getState(),enbook.getId(),enbook.getUid());
    }
    @RequestMapping("/Menu/showRecord")
    private Result showRecord(@RequestBody Integer Uid) {

        return showRecordService.show(Uid);
    }
}
