package com.tinchop.spring.boot.playground.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "task")
@Getter
@Setter
public class TaskConfig {

    private boolean animalCreation;
    private boolean concurrentAnimalCreation;
    private boolean concurrentIntroductions;
    private boolean deadlock;
}
