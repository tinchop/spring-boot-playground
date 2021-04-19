package com.tinchop.spring.boot.playground.task.concurrency;

import com.tinchop.spring.boot.playground.model.Human;
import com.tinchop.spring.boot.playground.model.Owl;
import com.tinchop.spring.boot.playground.service.HumanService;
import com.tinchop.spring.boot.playground.service.OwlService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class DeadlockTask {

    private final OwlService owlService;
    private final HumanService humanService;

    // @Scheduled(fixedRate = 999999999)
    public void deadlock() {

        Owl owl = owlService.createRandomAndSave();
        Human human = humanService.createRandomAndSave();

        Runnable r1 = () -> {

            log.info("Thread 1: trying to lock OWL");
            synchronized (owl) {
                log.info("Thread 1: OWL locked.");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                log.info("Thread 1: trying to lock HUMAN");
                synchronized (human) {
                    log.info("Thread 1: HUMAN locked.");
                }

            }

            log.info("Thread 1: execution complete");
        };

        Runnable r2 = () -> {

            log.info("Thread 2: trying to lock HUMAN");
            synchronized (human) {
                log.info("Thread 2: HUMAN locked.");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                log.info("Thread 2: trying to lock OWL");
                synchronized (owl) {
                    log.info("Thread 2: OWL locked.");
                }

            }

            log.info("Thread 2: execution complete");
        };
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();

    }

}
