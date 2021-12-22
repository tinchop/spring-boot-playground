package com.tinchop.spring.boot.playground.model.animal;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Entity;

@Slf4j
@SuperBuilder
@Entity
@RequiredArgsConstructor
@Getter
public class Dolphin extends Animal {

    @Override
    public void introduction() {
        log.info("I'm a dolphin");
    }

    @Override
    public String toString() {
        return "Dolphin";
    }
}
