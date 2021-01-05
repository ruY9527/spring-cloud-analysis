package com.iyang.nacos.provider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Yang on 2021/1/5 22:06
 */

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping
    public String hello(){

        return "This is GavinYang";
    }


}
