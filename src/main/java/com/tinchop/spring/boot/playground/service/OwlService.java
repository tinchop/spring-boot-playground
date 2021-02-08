package com.tinchop.spring.boot.playground.service;

import com.tinchop.spring.boot.playground.model.Owl;
import com.tinchop.spring.boot.playground.repository.OwlRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OwlService {

    private final OwlRepository repository;

    public Owl save(Owl owl) {
        return repository.save(owl);
    }

    public List<Owl> findAll() {
        return repository.findAll();
    }

}
