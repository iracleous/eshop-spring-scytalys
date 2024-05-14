package com.scytalys.eshop.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class HardService {

    @Async
    public CompletableFuture<String> doSomethingHard() {
        log.info("Hard service doSomething starts");
        try {
            // Simulate a long-running task
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("Hard service doSomething ends");
        String returnValue = "Hard service doSomething ends";
        return CompletableFuture.completedFuture(returnValue);
    }
}
