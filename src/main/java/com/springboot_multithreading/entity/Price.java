package com.springboot_multithreading.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Author: Sandeep Singh
 * Date: 21/05/25
 */

@Entity
@Table(name = "price")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Price {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private double price;

    private LocalDateTime validFrom;

    private LocalDateTime validTo;

    private String status;
}