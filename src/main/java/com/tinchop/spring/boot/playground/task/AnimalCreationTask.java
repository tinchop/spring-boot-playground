package com.tinchop.spring.boot.playground.task;

import com.tinchop.spring.boot.playground.model.Animal;
import com.tinchop.spring.boot.playground.model.Dolphin;
import com.tinchop.spring.boot.playground.model.Horse;
import com.tinchop.spring.boot.playground.model.Owl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;

@Slf4j
@Component
public class AnimalCreationTask {

    @Scheduled(fixedRate = 2000)
    public void createAnimal() {
        Animal animal;
        Random random = new Random();
        Integer number = random.ints(0, 14)
                .findFirst()
                .getAsInt();

        if (number.intValue() > 9) {
            animal = Owl.builder().name("Tom").build();
        } else if (number > 4) {
            animal = Horse.builder().name("Fred").build();
        } else {
            animal = Dolphin.builder().name("Mike").build();
        }

        animal.introduction();

    }

}
