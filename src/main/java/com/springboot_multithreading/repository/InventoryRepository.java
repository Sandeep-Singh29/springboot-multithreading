package com.springboot_multithreading.repository;

import com.springboot_multithreading.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Author: Sandeep Singh
 * Date: 21/05/25
 */

@Repository
public interface InventoryRepository extends JpaRepository<Inventory,Long> {

    Inventory findByProductId(Long productId);
}
