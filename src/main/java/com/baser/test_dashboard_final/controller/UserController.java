package com.baser.test_dashboard_final.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/user/profile")
    public String getProfile() {
        return "Authenticated!";
    }
}
