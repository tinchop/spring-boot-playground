package com.tinchop.spring.boot.playground.service;

import constant.SbpMessages;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MiscService {

    String emptyIfNull(String input) {
        return Optional.ofNullable(input).orElse("");
    }

    String enforceNotNull(String value) {
        return Optional.ofNullable(value).orElseThrow(() -> new RuntimeException(SbpMessages.CANNOT_BE_NULL));
    }

}
