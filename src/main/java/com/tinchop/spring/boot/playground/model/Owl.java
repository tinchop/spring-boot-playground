package com.tinchop.spring.boot.playground.model;

import lombok.Builder;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class Owl extends Animal {

    @Builder
    public Owl(String name) {
        super(name);
    }

    @Override
    public void introduction() {
        log.info("I'm an owl and my name is {}", name);
    }
}
