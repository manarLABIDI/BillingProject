package com.example.demo.proxies;

import com.example.demo.beans.ProductBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "PRODUCT-SERVICE")
public interface InventoryServiceProxy {
    @GetMapping("/products/{id}")
    public ProductBean findProductById(@PathVariable(name = "id") Long id);
}
