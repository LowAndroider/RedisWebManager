package com.djh.module.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Djh
 */
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

    @GetMapping("/addConn")
    public String addConn(String type, Model model) {
        model.addAttribute("type", type);
        return "/page/conn_add.html";
    }
}
