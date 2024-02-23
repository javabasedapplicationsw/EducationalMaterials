package com.train.aws2.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HelloController {

    @GetMapping("/")
    public String aws1() {
        log.info("get /");
        return "sweet home";
    }

    @GetMapping("/aws/2")
    public String aws2() {
        log.info("get /aws/2");
        return "<h1>aws2</h1>";
    }
}
















