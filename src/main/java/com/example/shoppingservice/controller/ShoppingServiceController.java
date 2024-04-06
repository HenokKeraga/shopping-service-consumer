package com.example.shoppingservice.controller;

import com.example.shoppingservice.util.BillInfoClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShoppingServiceController {
    private final BillInfoClient billInfoClient;

    public ShoppingServiceController(BillInfoClient billInfoClient) {
        this.billInfoClient = billInfoClient;
    }

    @GetMapping("/shop")
    public ResponseEntity<String> shop() {

        return new ResponseEntity<>("shopping service " +billInfoClient.getBillInfo(), HttpStatus.OK);
    }
}
