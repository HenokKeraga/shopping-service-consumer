package com.example.shoppingservice.util;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;

@Component
public class BillInfoClient {

    final DiscoveryClient discoveryClient;


    public BillInfoClient(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    public String getBillInfo() {

        List<ServiceInstance> instances = discoveryClient.getInstances("BILLING-INFO");
        var bastUri = instances.getFirst().getUri();

        var body = RestClient.create().get().uri(bastUri + "/bill-info").retrieve().body(String.class);

        return body;

    }
}
