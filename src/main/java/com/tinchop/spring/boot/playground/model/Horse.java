package com.tinchop.spring.boot.playground.model;

import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Horse extends Animal {

    @Builder
    public Horse(String name) {
        super(name);
    }

    @Override
    public void introduction() {
        log.info("I'm a horse and my name is {}", name);
    }
}
