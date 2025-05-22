package com.springboot_multithreading.service;

import com.springboot_multithreading.entity.Price;

/**
 * Author: Sandeep Singh
 * Date: 21/05/25
 */

public interface PriceService {

    Price  getPriceByProductId(Long productID);

}
