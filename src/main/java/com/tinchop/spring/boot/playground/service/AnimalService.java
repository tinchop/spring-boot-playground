package com.tinchop.spring.boot.playground.service;

import com.tinchop.spring.boot.playground.model.Animal;

public interface AnimalService<T extends Animal> {

    T createRandomAndSave();

}
