package com.springboot_multithreading.controller;

import com.springboot_multithreading.service.impl.ImageProcessingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Author: Sandeep Singh
 * Date: 22/05/25
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/images")
public class ImageController {

    private final ImageProcessingService imageProcessingService;

    @PostMapping("/process")
    public String imageProcessor(@RequestBody List<String> imagePaths) {
        imageProcessingService.processImage(imagePaths);
        return "Image Processing Started";
    }

}

