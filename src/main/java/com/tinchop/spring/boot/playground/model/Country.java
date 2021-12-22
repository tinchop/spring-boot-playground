package com.tinchop.spring.boot.playground.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@SuperBuilder
@Entity
@Getter
@RequiredArgsConstructor
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String name;

}
