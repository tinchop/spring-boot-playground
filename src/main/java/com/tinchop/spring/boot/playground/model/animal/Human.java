package com.tinchop.spring.boot.playground.model.animal;

import com.tinchop.spring.boot.playground.model.Country;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Optional;

@Slf4j
@SuperBuilder
@Entity
@Getter
@RequiredArgsConstructor
public class Human extends Animal {

    @Column(nullable = false)
    protected String firstName;
    @ManyToOne
    @JoinColumn
    private Country countryOfBirth;

    @Override
    public void introduction() {
        log.info("I'm a human");
    }

    @Override
    public String toString() {
        return "Human";
    }


}
