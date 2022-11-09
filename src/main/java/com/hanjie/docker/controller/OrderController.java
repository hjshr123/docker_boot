package com.hanjie.docker.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.UUID;

public class OrderController {
    @Value("${server.port}")
    private String port;

    @GetMapping("/order/docker")
    public String helloDocker(){
        return port+"\t"+ UUID.randomUUID();
    }
}
