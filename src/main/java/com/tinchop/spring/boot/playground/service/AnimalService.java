package com.tinchop.spring.boot.playground.service;

import com.tinchop.spring.boot.playground.model.animal.Animal;

public interface AnimalService<T extends Animal> {

    T createRandomAndSave();

}
