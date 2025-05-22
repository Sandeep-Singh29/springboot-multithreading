package com.springboot_multithreading.service.impl;

import com.springboot_multithreading.entity.Inventory;
import com.springboot_multithreading.repository.InventoryRepository;
import com.springboot_multithreading.service.InventoryService;
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
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;

    @Override
    public Inventory getInventoryByProductId(Long productId) {
        log.info("Getting Inventory for the ProductId {}", productId);
        addDelay();
        return inventoryRepository.findByProductId(productId);
    }

    private void addDelay() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
