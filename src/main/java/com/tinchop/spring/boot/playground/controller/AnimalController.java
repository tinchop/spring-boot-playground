package com.tinchop.spring.boot.playground.controller;

import com.tinchop.spring.boot.playground.model.animal.Animal;
import com.tinchop.spring.boot.playground.service.DolphinService;
import com.tinchop.spring.boot.playground.service.HumanService;
import com.tinchop.spring.boot.playground.service.OwlService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/animal")
@AllArgsConstructor
public class AnimalController {

    private final HumanService humanService;
    private final DolphinService dolphinService;
    private final OwlService owlService;

    @GetMapping("/all")
    public ResponseEntity<List<Animal>> all() {
        List<Animal> animals = new ArrayList<>();

        animals.addAll(humanService.findAll());
        animals.addAll(dolphinService.findAll());
        animals.addAll(owlService.findAll());

        return ResponseEntity.ok(animals);
    }

}
