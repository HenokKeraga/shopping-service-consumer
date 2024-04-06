package com.example.shoppingservice.controller;

import com.example.shoppingservice.util.BillInfoDiscoveryClient;
import com.example.shoppingservice.util.BillInfoFeignClient;
import com.example.shoppingservice.util.BillInfoLoadBalancerClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShoppingServiceController {
    private final BillInfoDiscoveryClient billInfoDiscoveryClient;
    private final BillInfoLoadBalancerClient billInfoLoadBalancerClient;
    private final BillInfoFeignClient billInfoFeignClient;

    public ShoppingServiceController(BillInfoDiscoveryClient billInfoDiscoveryClient, BillInfoLoadBalancerClient billInfoLoadBalancerClient, BillInfoFeignClient billInfoFeignClient) {
        this.billInfoDiscoveryClient = billInfoDiscoveryClient;
        this.billInfoLoadBalancerClient = billInfoLoadBalancerClient;
        this.billInfoFeignClient = billInfoFeignClient;
    }

    @GetMapping("/shop")
    public ResponseEntity<String> shop() {

    //    return new ResponseEntity<>("shopping service " + billInfoDiscoveryClient.getBillInfo(), HttpStatus.OK);
       // return new ResponseEntity<>("shopping service " + billInfoLoadBalancerClient.getBillInfo(), HttpStatus.OK);
        return new ResponseEntity<>("shopping service " + billInfoFeignClient.invokeShop().getBody(), HttpStatus.OK);
    }
}
