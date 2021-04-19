package com.tinchop.spring.boot.playground.task.concurrency;

import com.tinchop.spring.boot.playground.model.Dolphin;
import com.tinchop.spring.boot.playground.model.Human;
import com.tinchop.spring.boot.playground.model.Owl;
import com.tinchop.spring.boot.playground.service.DolphinService;
import com.tinchop.spring.boot.playground.service.HumanService;
import com.tinchop.spring.boot.playground.service.OwlService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class ConcurrentIntroductionsTask {

    private final HumanService humanService;
    private final DolphinService dolphinService;
    private final OwlService owlService;

    // @Scheduled(fixedRate = 3000)
    public void concurrentIntroductions() {

        Human human = humanService.createRandomAndSave();
        Dolphin dolphin = dolphinService.createRandomAndSave();
        Owl owl = owlService.createRandomAndSave();

        Runnable r1 = human::introduction;
        Runnable r2 = dolphin::introduction;
        Runnable r3 = owl::introduction;

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
            log.info("****** Threads joined. ******");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
