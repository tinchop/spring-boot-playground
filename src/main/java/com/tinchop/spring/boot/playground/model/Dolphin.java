package com.tinchop.spring.boot.playground.model;

import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Dolphin extends Animal {

    @Builder
    public Dolphin(String name) {
        super(name);
    }

    @Override
    public void introduction() {
        log.info("I'm a dolphin and my name is {}", name);
    }
}
