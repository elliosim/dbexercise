package com.example.dbexercise.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class NaceDetailsController {

    @PostMapping("/putNaceDetails")
    public void putNaceDetails() {

    }
}
