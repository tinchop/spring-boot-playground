package com.tinchop.spring.boot.playground.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Entity;


@Slf4j
@SuperBuilder
@Entity
@Getter
@RequiredArgsConstructor
public class Owl extends Animal {

    @Override
    public void introduction() {
        log.info("I'm an owl");
    }

    @Override
    public String toString() {
        return "Owl";
    }
}
