package com.djh.module.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedisController {

    @GetMapping("/content")
    public String main() {

        return "/page/main.html";
    }

    @GetMapping("/")
    public String index() {

        return "index.html";
    }
}
