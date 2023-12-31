package com.example.demo.proxies;

import com.example.demo.beans.CustomerBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerServiceProxy {
    @GetMapping("/customers/{id}")
    public CustomerBean findCustomerById(@PathVariable(name = "id") Long id);
}