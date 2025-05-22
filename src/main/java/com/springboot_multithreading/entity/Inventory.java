package com.springboot_multithreading.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: Sandeep Singh
 * Date: 21/05/25
 */

@Entity
@Table(name = "inventory")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Inventory {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private Long warehouseId;

    private Integer availableQuantity;

    private Integer reservedQuantity;

    private String status;
}
