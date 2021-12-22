package com.tinchop.spring.boot.playground.repository;

import com.tinchop.spring.boot.playground.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
