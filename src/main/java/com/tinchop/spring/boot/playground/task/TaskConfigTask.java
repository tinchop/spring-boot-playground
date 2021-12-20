package com.tinchop.spring.boot.playground.task;

import com.tinchop.spring.boot.playground.config.TaskConfig;
import com.tinchop.spring.boot.playground.model.Animal;
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
@ConditionalOnProperty(value = "task.task-config", havingValue = "true")
public class TaskConfigTask {

    private final TaskConfig taskConfig;

    @Scheduled(fixedRate = 10000)
    public void logTaskConfig() {

        log.info("animal-creation: {}", enabledString(taskConfig.isAnimalCreation()));
        log.info("concurrent-animal-creation: {}", enabledString(taskConfig.isConcurrentAnimalCreation()));
        log.info("concurrent-introductions: {}", enabledString(taskConfig.isConcurrentIntroductions()));
        log.info("deadlock: {}", enabledString(taskConfig.isDeadlock()));

    }

    private String enabledString(boolean value) {
        return value ? "enabled" : "disabled";
    }

}
