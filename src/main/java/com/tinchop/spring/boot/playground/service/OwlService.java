package com.tinchop.spring.boot.playground.service;

import com.tinchop.spring.boot.playground.model.Animal;
import com.tinchop.spring.boot.playground.model.Owl;
import com.tinchop.spring.boot.playground.repository.OwlRepository;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OwlService implements AnimalService<Animal> {

    private final OwlRepository repository;

    private Owl createRandom() {
        return Owl.builder().weight(RandomUtils.nextDouble()).build();
    }

    @Override
    public Owl createRandomAndSave() {
        return repository.save(createRandom());
    }

    public List<Owl> findAll() {
        return repository.findAll();
    }

}
