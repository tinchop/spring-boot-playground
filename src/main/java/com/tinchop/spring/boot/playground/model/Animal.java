package com.tinchop.spring.boot.playground.model;

import lombok.AllArgsConstructor;
import lombok.NonNull;


@AllArgsConstructor
public abstract class Animal {

    @NonNull
    protected String name;

    public abstract void introduction();
}
