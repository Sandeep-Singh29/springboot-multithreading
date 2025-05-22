package com.springboot_multithreading.controller;

import com.springboot_multithreading.dto.ProductDetailsDTO;
import com.springboot_multithreading.facade.ProductAsyncFacade;
import com.springboot_multithreading.facade.ProductSyncFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: Sandeep Singh
 * Date: 22/05/25
 */

@RestController
@RequestMapping("/api/v1/products")
@Slf4j
@RequiredArgsConstructor
public class ProductController {


    private final ProductAsyncFacade productAsyncFacade;
    private final ProductSyncFacade productSyncFacade;


    @GetMapping("/{pId}/sync")
    public ResponseEntity<ProductDetailsDTO> getProductSync(@PathVariable long pId) {
        log.info("Controller Request to get Product by Id SYNC Call :: {}", pId);
        return ResponseEntity.ok(productSyncFacade.getProductDetails(pId));
    }

    @GetMapping("/{pId}/async")
    public ResponseEntity<ProductDetailsDTO> getProductAsync(@PathVariable Long pId) {
        log.info("Controller Request to get Product by Id ASYNC Call :: {}", pId);
        return ResponseEntity.ok(productAsyncFacade.getProductDetails(pId));
    }

}
