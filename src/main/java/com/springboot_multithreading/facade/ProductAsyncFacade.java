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
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

/**
 * Author: Sandeep Singh
 * Date: 22/05/25
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class ProductAsyncFacade {


    private final InventoryService inventoryService;
    private final PriceService priceService;
    private final ProductService productService;

    // Thread for Product
    public CompletableFuture<Product> getProductById(long productId) {
        return CompletableFuture.supplyAsync(() -> productService.findById(productId));
    }

    // Thread for Price
    public CompletableFuture<Price> getPriceByProductById(long productId) {
        return CompletableFuture.supplyAsync(() -> priceService.getPriceByProductId(productId));
    }
    
    // Thread for Inventory
    public CompletableFuture<Inventory> getInventoryByProductById(long productId) {
        return CompletableFuture.supplyAsync(() -> inventoryService.getInventoryByProductId(productId));
    }


    public ProductDetailsDTO getProductDetails(long productId) {

        // fetch all Async Thread
        CompletableFuture<Product> productFuture = getProductById(productId);
        CompletableFuture<Price> priceFuture = getPriceByProductById(productId);
        CompletableFuture<Inventory> inventoryFuture = getInventoryByProductById(productId);

        // wait for all features to complete
        CompletableFuture.allOf(productFuture, priceFuture, inventoryFuture);

        // Combine the result
        Product product = productFuture.join();
        Price price = priceFuture.join();
        Inventory inventory = inventoryFuture.join();

        // Collect all data in DTO and Return
        return new ProductDetailsDTO(productId, product.getCategory(), product.getName(), product.getDescription(), inventory.getAvailableQuantity(), price.getPrice(), inventory.getStatus());
    }

}
