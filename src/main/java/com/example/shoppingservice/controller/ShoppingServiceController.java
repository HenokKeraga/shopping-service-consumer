package com.example.shoppingservice.controller;

import com.example.shoppingservice.util.BillInfoDiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShoppingServiceController {
    private final BillInfoDiscoveryClient billInfoDiscoveryClient;

    public ShoppingServiceController(BillInfoDiscoveryClient billInfoDiscoveryClient) {
        this.billInfoDiscoveryClient = billInfoDiscoveryClient;
    }

    @GetMapping("/shop")
    public ResponseEntity<String> shop() {

        return new ResponseEntity<>("shopping service " + billInfoDiscoveryClient.getBillInfo(), HttpStatus.OK);
    }
}
