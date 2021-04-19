package com.tinchop.spring.boot.playground.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Column;
import javax.persistence.Entity;

@Slf4j
@SuperBuilder
@Entity
@RequiredArgsConstructor
@Getter
public class Human extends Animal {

    @Column(nullable = false)
    protected String firstName;

    @Override
    public void introduction() {
        log.info("I'm a human");
    }

    @Override
    public String toString() {
        return "Human";
    }
}
