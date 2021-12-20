package com.tinchop.spring.boot.playground.service;

import constant.SbpMessages;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(properties = "app.scheduling.enabled=false")
@ActiveProfiles("test")
public class MiscServiceTest {

    @Autowired
    private MiscService service;

    @Test
    public void emptyIfNullTest() {
        //Given
        String value = null;
        //When
        String emptyString = service.emptyIfNull(value);

        //Then
        Assertions.assertEquals("", emptyString);
    }

    @Test
    public void enforceNotNullTest() {
        //Given
        String value = null;

        var exception = Assertions.assertThrows(RuntimeException.class, () -> {
            //When
            service.enforceNotNull(value);
        });

        //Then
        Assertions.assertEquals(SbpMessages.CANNOT_BE_NULL, exception.getMessage());
    }
}
