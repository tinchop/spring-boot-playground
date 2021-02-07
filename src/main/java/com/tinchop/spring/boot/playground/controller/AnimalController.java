package com.tinchop.spring.boot.playground.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/animal")
public class AnimalController {

    @GetMapping
    public String home() {
        return "animal";
    }

}
