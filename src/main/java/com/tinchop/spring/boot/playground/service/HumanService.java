package com.tinchop.spring.boot.playground.service;

import com.tinchop.spring.boot.playground.model.Human;
import com.tinchop.spring.boot.playground.repository.HumanRepository;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HumanService implements AnimalService<Human> {

    private final HumanRepository repository;

    private Human createRandom() {
        return Human.builder().weight(RandomUtils.nextDouble()).firstName(RandomStringUtils.randomAlphabetic(8)).build();
    }

    @Override
    public Human createRandomAndSave() {
        return repository.save(createRandom());
    }

    public List<Human> findAll() {
        return repository.findAll();
    }

}
