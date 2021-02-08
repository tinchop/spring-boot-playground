package com.tinchop.spring.boot.playground.service;

import com.tinchop.spring.boot.playground.model.Human;
import com.tinchop.spring.boot.playground.repository.HumanRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HumanService {

    private final HumanRepository repository;

    public Human save(Human human) {
        return repository.save(human);
    }

    public List<Human> findAll() {
        return repository.findAll();
    }

}
