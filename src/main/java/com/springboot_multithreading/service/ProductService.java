package com.springboot_multithreading.service;

import com.springboot_multithreading.entity.Product;

/**
 * Author: Sandeep Singh
 * Date: 21/05/25
 */

public interface ProductService {

    Product findById(Long pId);
}
