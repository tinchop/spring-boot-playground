package com.tinchop.spring.boot.playground.service;

import com.tinchop.spring.boot.playground.model.Dolphin;
import com.tinchop.spring.boot.playground.repository.DolphinRepository;
import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@SpringBootTest(properties = "app.scheduling.enabled=false")
@ActiveProfiles("test")
public class DolphinServiceTest {

    @Autowired
    private DolphinService service;

    @Autowired
    private DolphinRepository repository;

    @AfterEach
    void afterEach() {
        repository.deleteAll();
    }

    @Test
    public void findAllTest() {
        // Given
        Dolphin d1 = Dolphin.builder().weight(RandomUtils.nextDouble()).build();
        Dolphin d2 = Dolphin.builder().weight(RandomUtils.nextDouble()).build();

        repository.save(d1);
        repository.save(d2);

        // When
        List<Dolphin> dolphins = service.findAll();

        //Then
        Assertions.assertEquals(2L, dolphins.size());

    }

    @Test
    public void createRandomAndSaveTest() {
        // Given
        // When
        service.createRandomAndSave();
        service.createRandomAndSave();
        service.createRandomAndSave();

        //Then
        Assertions.assertEquals(3L, repository.findAll().size());

    }

}
