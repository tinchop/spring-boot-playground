package com.tinchop.spring.boot.playground.task.concurrency;

import com.tinchop.spring.boot.playground.model.Animal;
import com.tinchop.spring.boot.playground.service.DolphinService;
import com.tinchop.spring.boot.playground.service.HumanService;
import com.tinchop.spring.boot.playground.service.OwlService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Slf4j
@Component
@AllArgsConstructor
public class ConcurrentAnimalCreationTask {

    private final HumanService humanService;
    private final DolphinService dolphinService;
    private final OwlService owlService;

    // @Scheduled(fixedRate = 3000)
    public void concurrentAnimalCreation() {

        // List<Animal> animals = new ArrayList<>(); *** ArrayList is not thread-safe! ***
        List<Animal> animals = Collections.synchronizedList(new ArrayList<>()); // Now it is!

        Runnable r1 = () -> animals.add(humanService.createRandomAndSave());
        Runnable r2 = () -> animals.add(owlService.createRandomAndSave());
        Runnable r3 = () -> animals.add(dolphinService.createRandomAndSave());

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        Thread t3 = new Thread(r3);

        t1.start();
        t2.start();
        t3.start();

        try {
            int millis = 1000;
            t1.join(millis);
            t2.join(millis);
            t3.join(millis);

            log.info(Arrays.toString(animals.toArray()));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
