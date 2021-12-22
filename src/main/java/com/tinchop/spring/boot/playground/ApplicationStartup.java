package com.tinchop.spring.boot.playground;

import com.tinchop.spring.boot.playground.service.CountryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Slf4j
@AllArgsConstructor
@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {

    private final CountryService countryService;

    /**
     * This event is executed as late as conceivably possible to indicate that
     * the application is ready to service requests.
     */
    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {

        countryService.insertInitialCountries();

    }
}