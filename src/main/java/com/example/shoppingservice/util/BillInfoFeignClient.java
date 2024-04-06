package com.example.shoppingservice.util;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("BILLING-INFO")
public interface BillInfoFeignClient {

    @GetMapping("/bill-info")
    ResponseEntity<String> invokeShop();
}
