package com.springboot_multithreading.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Author: Sandeep Singh
 * Date: 22/05/25
 */

@Service
@Slf4j
public class ImageProcessingService {

    private final ExecutorService executorService = Executors.newFixedThreadPool(5);


    public void processImage(List<String> listPaths) {
        for (String imagePath : listPaths) {
            executorService.submit(() -> compressImage(imagePath));
            //compressImage(imagePath);  without executorService multithreading
        }
    }

    private void compressImage(String imagePath) {
        try {
            log.info("Processing Start ImagePath :: With ThreadName :: {} {}", imagePath, Thread.currentThread().getName());
            Thread.sleep(3000);
            log.info("Processing Completed ImagePath {}", imagePath);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}