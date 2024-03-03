package ru.panov.feignclient.scheduller;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.panov.feignclient.service.Calculate;

@RequiredArgsConstructor
@Component
public class Scheduler {

    private final Calculate calculate;

    @Scheduled(fixedDelay = 5000)
    public void Shedow(){
        calculate.calculateCalorie();
    }
}
