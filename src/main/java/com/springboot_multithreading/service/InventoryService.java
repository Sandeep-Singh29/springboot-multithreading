package com.springboot_multithreading.service;

import com.springboot_multithreading.entity.Inventory;

/**
 * Author: Sandeep Singh
 * Date: 21/05/25
 */

public interface InventoryService {

    Inventory getInventoryByProductId(Long productId);

}
