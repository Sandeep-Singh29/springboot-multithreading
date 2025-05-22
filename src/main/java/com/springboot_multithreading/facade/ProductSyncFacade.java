package com.springboot_multithreading.facade;

import com.springboot_multithreading.dto.ProductDetailsDTO;
import com.springboot_multithreading.entity.Inventory;
import com.springboot_multithreading.entity.Price;
import com.springboot_multithreading.entity.Product;
import com.springboot_multithreading.service.InventoryService;
import com.springboot_multithreading.service.PriceService;
import com.springboot_multithreading.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Author: Sandeep Singh
 * Date: 21/05/25
 */


@Component
@Slf4j
@RequiredArgsConstructor
public class ProductSyncFacade {

    private final InventoryService inventoryService;
    private final PriceService priceService;
    private final ProductService productService;


    public ProductDetailsDTO getProductDetails(long productId) {
        log.info("Sync Facade for getting product details for the productId : {}", productId);
        // fetch product
        Product product = productService.findById(productId);

        // fetch price
        Price price = priceService.getPriceByProductId(productId);

        // fetch inventory
        Inventory inventory = inventoryService.getInventoryByProductId(productId);

        return new ProductDetailsDTO(productId, product.getCategory(), product.getName(), product.getDescription(), inventory.getAvailableQuantity(), price.getPrice(), inventory.getStatus());
    }

}
