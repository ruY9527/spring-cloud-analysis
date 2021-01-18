package com.iyang.nacos.consumer.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author Yang
 *
 */

@RestController
@RequestMapping("/instance")
public class CallInstanceController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    private String serverName = "nacos-provider";

    /**
     *  获取 Info 信息.
     * @return
     */
    @GetMapping("/info")
    public String info(){
        List<ServiceInstance> instances = discoveryClient.getInstances(serverName);
        StringBuilder sb = new StringBuilder();
        sb.append("All Services is ---> " + discoveryClient.getServices() + "</br>");
        sb.append("nacos-provider instance list : </br>");
        instances.forEach( serviceInstance -> {
            sb.append("[ServiceId: " + serviceInstance.getServiceId() +
                    " , host :" + serviceInstance.getHost() +
                    " , port :" + serviceInstance.getPort() + "]");
        });
        return sb.toString();
    }

    /**
     *
     * @return
     */
    @GetMapping("/hello")
    public String hello(){
        List<ServiceInstance> instances = discoveryClient.getInstances(serverName);
        ServiceInstance serviceInstance = instances.stream().findAny().orElseThrow(() ->
                new IllegalStateException("no " + serverName + " instance available"));
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() +
                     "/hello";
        return restTemplate.getForObject(url, String.class);
    }

}
