package com.tinchop.spring.boot.playground.controller;

import com.tinchop.spring.boot.playground.model.animal.Animal;
import com.tinchop.spring.boot.playground.service.DolphinService;
import com.tinchop.spring.boot.playground.service.HumanService;
import com.tinchop.spring.boot.playground.service.OwlService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/animal")
public class AnimalController {

    private HumanService humanService;
    private DolphinService dolphinService;
    private OwlService owlService;

    @Value("${big-animal-threshold}")
    private double bigAnimalThreshold;

    public AnimalController(HumanService humanService, DolphinService dolphinService, OwlService owlService) {
        this.humanService = humanService;
        this.dolphinService = dolphinService;
        this.owlService = owlService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Animal>> all() {
        return ResponseEntity.ok(retrieveAll());
    }

    @GetMapping("/big")
    public ResponseEntity<List<Animal>> bigAnimals() {
        var animals = retrieveAll();
        animals = animals.stream().filter(a -> a.getWeight() >= bigAnimalThreshold).collect(Collectors.toList());
        return ResponseEntity.ok(animals);
    }

    private List<Animal> retrieveAll() {
        List<Animal> animals = new ArrayList<>();

        animals.addAll(humanService.findAll());
        animals.addAll(dolphinService.findAll());
        animals.addAll(owlService.findAll());

        return animals;
    }

}
