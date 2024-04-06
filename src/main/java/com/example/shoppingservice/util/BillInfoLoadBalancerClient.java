package com.example.shoppingservice.util;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class BillInfoLoadBalancerClient {
    private final LoadBalancerClient loadBalancerClient;

    public BillInfoLoadBalancerClient(LoadBalancerClient loadBalancerClient) {
        this.loadBalancerClient = loadBalancerClient;
    }

    public String getBillInfo() {
        var instance = loadBalancerClient.choose("BILLING-INFO");
        var baseUri = instance.getUri();

        return RestClient.create().get().uri(baseUri + "/bill-info").retrieve().body(String.class);

    }
}
