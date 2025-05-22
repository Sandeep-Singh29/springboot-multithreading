package com.springboot_multithreading.controller;

import com.springboot_multithreading.service.impl.MyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: Sandeep Singh
 * Date: 22/05/25
 */

@RestController
@RequiredArgsConstructor
public class MyController {

    private final MyService myService;

    @GetMapping("/test-task")
    public String testTask() {
        for (int i = 0; i <= 10; i++) {
            myService.performTask(i);
        }
        return "Task Started Successfully";
    }

}
