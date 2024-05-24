package com.springboot.utils;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;  
import java.util.concurrent.TimeUnit;  
import org.springframework.stereotype.Component;  
  
@Component  
public class ScheduleTask {
  
    private final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();  
      
    public void startCountdown(Long seconds, Runnable task) {  
        executorService.schedule(task, seconds, TimeUnit.SECONDS);  
    }  
  
    // 可能还需要一个方法来关闭ExecutorService（在实际应用中）  
    public void shutdown() {  
        executorService.shutdown(); // 或者使用shutdownNow()来立即停止所有任务  
    }  
}