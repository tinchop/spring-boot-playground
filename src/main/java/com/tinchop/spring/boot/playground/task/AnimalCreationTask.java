package com.tinchop.spring.boot.playground.task;

import com.tinchop.spring.boot.playground.model.Animal;
import com.tinchop.spring.boot.playground.service.DolphinService;
import com.tinchop.spring.boot.playground.service.HumanService;
import com.tinchop.spring.boot.playground.service.OwlService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class AnimalCreationTask {

    private final HumanService humanService;
    private final DolphinService dolphinService;
    private final OwlService owlService;

    // @Scheduled(fixedRate = 2000)
    public void createAnimal() {

        Animal animal = switch (RandomUtils.nextInt(1, 4)) {
            case 1 -> humanService.createRandomAndSave();
            case 2 -> owlService.createRandomAndSave();
            default -> dolphinService.createRandomAndSave();
        };

        animal.introduction();

    }

}
