package com.iyang.eurekac.lient.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Yang
 * 当前服务 : eureka-client
 * @date 2021/1/4 / 17:11
 */

@RestController
@RequestMapping(value = "hello")
public class HelloController {

    @GetMapping
    public String hello(){
        return "Hello;GavinYang.";
    }


}
