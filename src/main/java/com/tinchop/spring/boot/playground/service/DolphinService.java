package com.tinchop.spring.boot.playground.service;

import com.tinchop.spring.boot.playground.model.Dolphin;
import com.tinchop.spring.boot.playground.repository.DolphinRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DolphinService {

    private final DolphinRepository repository;

    public Dolphin save(Dolphin dolphin) {
        return repository.save(dolphin);
    }

    public List<Dolphin> findAll() {
        return repository.findAll();
    }

}
