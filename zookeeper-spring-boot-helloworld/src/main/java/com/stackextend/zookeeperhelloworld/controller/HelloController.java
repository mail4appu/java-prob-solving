package com.stackextend.zookeeperhelloworld.controller;

import com.stackextend.zookeeperhelloworld.config.HelloProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class HelloController {

    HelloProperties helloProperties;

    public HelloController(HelloProperties helloProperties) {
        this.helloProperties = helloProperties;
    }

    @Value("${firstName}")
    private String firstName;

    @Value("${secondName}")
    private String secondName;

    @GetMapping("/properties/display")
    public HelloProperties displayProperties() {
        return helloProperties;
    }


    @GetMapping("/properties")
    public String display() {
        return firstName+secondName;
    }

}
