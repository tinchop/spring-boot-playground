package com.tinchop.spring.boot.playground.service;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MiscService {

    String emptyIfNull(String input) {
        return Optional.ofNullable(input).orElse("");
    }

}
