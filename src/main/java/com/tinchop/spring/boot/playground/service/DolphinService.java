package com.tinchop.spring.boot.playground.service;

import com.tinchop.spring.boot.playground.model.animal.Dolphin;
import com.tinchop.spring.boot.playground.repository.DolphinRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class DolphinService implements AnimalService<Dolphin> {

    private final DolphinRepository repository;

    private Dolphin createRandom() {
        return Dolphin.builder().weight(RandomUtils.nextDouble(100.0, 1000.0)).build();
    }

    @Override
    public Dolphin createRandomAndSave() {
        return repository.save(createRandom());
    }

    public List<Dolphin> findAll() {
        return repository.findAll();
    }

}
