package com.tinchop.spring.boot.playground.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = "app.scheduling.enabled=false")
public class MiscServiceTest {

    @Autowired
    private MiscService service;

    @Test
    public void emptyIfNullTest() {
        //Given
        //When
        String emptyString = service.emptyIfNull(null);

        //Then
        Assertions.assertEquals("", emptyString);
    }
}
