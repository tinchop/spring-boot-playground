package com.tinchop.spring.boot.playground.service;

import com.tinchop.spring.boot.playground.model.Animal;

interface AnimalService<T extends Animal> {

    T createRandomAndSave();

}
