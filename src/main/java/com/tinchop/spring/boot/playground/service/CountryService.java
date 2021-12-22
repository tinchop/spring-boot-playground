package com.tinchop.spring.boot.playground.service;

import com.tinchop.spring.boot.playground.model.Country;
import com.tinchop.spring.boot.playground.repository.CountryRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class CountryService {

    private final CountryRepository repository;

    public void insertInitialCountries() {
        log.info("*** Inserting initial countries...");
        repository.saveAll(List.of(
                Country.builder().id(1L).name("Argentina").build(),
                Country.builder().id(2L).name("Brasil").build(),
                Country.builder().id(3L).name("Uruguay").build()));
        log.info("*** Initial countries inserted.");
    }

}
