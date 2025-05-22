package com.springboot_multithreading.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Author: Sandeep Singh
 * Date: 22/05/25
 */

@Service
@Slf4j
public class MyService {


    @Async
    public void performTask(int taskId) {
        log.info("Task Id ->   started By :: {} {}", taskId, Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("Task Id ::   Completed By :: {} {}", taskId, Thread.currentThread().getName());
    }

}
