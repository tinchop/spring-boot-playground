package com.tinchop.spring.boot.playground.service;

import com.tinchop.spring.boot.playground.model.animal.Human;
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
    private final CountryService countryService;

    private Human createRandom() {
        return Human.builder()
                .weight(RandomUtils.nextDouble(30.0, 200.0))
                .countryOfBirth(countryService.getRandom())
                .firstName(RandomStringUtils.randomAlphabetic(8))
                .build();
    }

    @Override
    public Human createRandomAndSave() {
        return repository.save(createRandom());
    }

    public List<Human> findAll() {
        return repository.findAll();
    }

}
