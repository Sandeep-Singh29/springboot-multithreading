package com.springboot_multithreading.service.impl;

import com.springboot_multithreading.entity.Price;
import com.springboot_multithreading.repository.PriceRepository;
import com.springboot_multithreading.service.PriceService;
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
public class PriceServiceImpl implements PriceService {

    private final PriceRepository priceRepository;

    @Override
    public Price getPriceByProductId(Long productID) {
        log.info("Getting Price for the ProductId {}",productID);
        addDelay();
        return priceRepository.findByProductId(productID);
    }

    private void addDelay() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
