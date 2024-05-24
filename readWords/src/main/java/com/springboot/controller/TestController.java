package com.springboot.controller;

import com.springboot.domain.entity.Result;
import com.springboot.domain.vo.RecordVo;
import com.springboot.domain.vo.TestVo;
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
    @Autowired
    private TestService testService;
    @Autowired
    private final ScheduleTask scheduleTask = new ScheduleTask();

   /* @Autowired
    public TestController(ScheduledTask scheduledTask) {
        this.scheduledTask = scheduledTask;
    }*/
    /*@RequestMapping("/Menu/testStart")
    private Result testStart(@RequestBody TestVo test1) {
        testService.iftest(test1);
    }*/
    @RequestMapping("/Menu/test")
    private Result test(@RequestBody TestVo test1) {
        AtomicReference<Result> result = new AtomicReference<>();
        testService.test(test1.getUid(),test1.getTime());
        scheduleTask.startCountdown((long) (test1.getTime()), () -> {
            System.out.println( test1.getTime()*60+" seconds have passed! Performing a task...");
            result.set(testService.finish());// 在这里执行任务逻辑
        });

        return result.get();
        //return  reciteService.recite(enbook.getState(),enbook.getId(),enbook.getUid());
    }
    @RequestMapping("/Menu/record")
    private void record(@RequestBody RecordVo recordVo) {
        int id = recordVo.getId();
        int uid = recordVo.getUid();
        testService.record(uid,id);
        //return  reciteService.recite(enbook.getState(),enbook.getId(),enbook.getUid());
    }
}
