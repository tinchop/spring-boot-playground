package com.tinchop.spring.boot.playground.task;

import com.tinchop.spring.boot.playground.config.TaskConfig;
import com.tinchop.spring.boot.playground.model.animal.Animal;
import com.tinchop.spring.boot.playground.service.DolphinService;
import com.tinchop.spring.boot.playground.service.HumanService;
import com.tinchop.spring.boot.playground.service.OwlService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
@ConditionalOnProperty(value = "task.animal-creation", havingValue = "true")
public class AnimalCreationTask {

    private final HumanService humanService;
    private final DolphinService dolphinService;
    private final OwlService owlService;
    private final TaskConfig taskConfig;

    @Scheduled(fixedRate = 2000)
    public void createAnimal() {

        Animal animal = switch (RandomUtils.nextInt(1, 4)) {
            case 1 -> humanService.createRandomAndSave();
            case 2 -> owlService.createRandomAndSave();
            default -> dolphinService.createRandomAndSave();
        };

        animal.introduction();

    }

}
