package com.tinchop.spring.boot.playground.service;

import com.tinchop.spring.boot.playground.model.animal.Dolphin;
import com.tinchop.spring.boot.playground.repository.DolphinRepository;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DolphinService implements AnimalService<Dolphin> {

    private final DolphinRepository repository;

    private Dolphin createRandom() {
        return Dolphin.builder().weight(RandomUtils.nextDouble()).build();
    }

    @Override
    public Dolphin createRandomAndSave() {
        return repository.save(createRandom());
    }

    public List<Dolphin> findAll() {
        return repository.findAll();
    }

}
