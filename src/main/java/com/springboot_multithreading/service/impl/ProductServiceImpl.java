package com.springboot_multithreading.service.impl;

import com.springboot_multithreading.entity.Product;
import com.springboot_multithreading.repository.ProductRepository;
import com.springboot_multithreading.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Author: Sandeep Singh
 * Date: 21/05/25
 */

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {


    private final ProductRepository productRepository;

    @Override
    public Product findById(Long productId) {
        log.info("Service Request to fetch Product by Id : {}", productId);
        addDelay();
        return productRepository.findById(productId).orElseThrow(()-> new RuntimeException("Product Not Found"));
    }

    private void addDelay() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
