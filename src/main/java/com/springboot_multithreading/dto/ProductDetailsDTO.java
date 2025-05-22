package com.springboot_multithreading.dto;

import com.springboot_multithreading.entity.Category;
import lombok.*;

/**
 * Author: Sandeep Singh
 * Date: 21/05/25
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDetailsDTO {

    private Long id;
    private Category category;
    private String name;
    private String description;
    private Integer availableQuantity;
    private Double price;
    private String status;

}
