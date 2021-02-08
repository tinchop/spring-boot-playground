package com.tinchop.spring.boot.playground.task;

import com.tinchop.spring.boot.playground.model.Animal;
import com.tinchop.spring.boot.playground.model.Dolphin;
import com.tinchop.spring.boot.playground.model.Human;
import com.tinchop.spring.boot.playground.model.Owl;
import com.tinchop.spring.boot.playground.service.DolphinService;
import com.tinchop.spring.boot.playground.service.HumanService;
import com.tinchop.spring.boot.playground.service.OwlService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;

@Slf4j
@Component
@AllArgsConstructor
public class AnimalCreationTask {

    private final HumanService humanService;
    private final DolphinService dolphinService;
    private final OwlService owlService;

    @Scheduled(fixedRate = 2000)
    public void createAnimal() {
        Animal animal;
        Random random = new Random();
        int number = random.ints(0, 14)
                .findFirst()
                .orElseThrow();
        if (number > 9) {
            // animal = humanService.save(Human.builder().weight(75.0).firstName("Luis").build());
        } else if (number > 4) {
            animal = owlService.save(Owl.builder().weight(5.0).build());
        } else {
            animal = dolphinService.save(Dolphin.builder().weight(200.0).build());
        }
        //animal.introduction();


    }

}
