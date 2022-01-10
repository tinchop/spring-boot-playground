package com.tinchop.spring.boot.playground.service;

import com.tinchop.spring.boot.playground.model.Country;
import com.tinchop.spring.boot.playground.repository.CountryRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Slf4j
@Service
@AllArgsConstructor
public class CountryService {

    private final CountryRepository repository;
    private List<Country> cache;

    public Country getRandom() {
        if (CollectionUtils.isEmpty(cache)) cache = this.createCountriesCache();

        return cache.get(new Random().nextInt(cache.size()));
    }

    private List<Country> createCountriesCache() {
        log.info("*** Inserting initial countries...");
        var countries = List.of(
                Country.builder().name("Argentina").build(),
                Country.builder().name("Brasil").build(),
                Country.builder().name("Uruguay").build());
        repository.saveAll(countries);
        log.info("*** Initial countries inserted.");
        return countries;
    }

}
