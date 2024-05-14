package com.scytalys.eshop.scheduledtask;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ScheduledTasks {

    // This task will run every 5 seconds
    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        log.info("The time is now " + System.currentTimeMillis());
    }

    // This task will run every day at 10 AM
    @Scheduled(cron = "0 35 11 * * ?")
    public void dailyTask() {
        log.info("Executing daily task at 10 AM");
    }

    // This task will run with a fixed delay of 10 seconds
    // between the end of the last invocation
    // and the start of the next
    @Scheduled(fixedDelay = 10000)
    public void fixedDelayTask() {
        log.info("Fixed delay task - " + System.currentTimeMillis());
    }
}
