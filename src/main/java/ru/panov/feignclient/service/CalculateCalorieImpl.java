package ru.panov.feignclient.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.panov.feignclient.client.DTO.EatingDTO;
import ru.panov.feignclient.client.EatingFeignClient;

import java.util.List;


@RequiredArgsConstructor
@Service
public class CalculateCalorieImpl implements Calculate{

    private final EatingFeignClient eatingFeignClient;

    @Override
    public Integer calculateCalorie() {

        var eating = eatingFeignClient.getEatingPersonId(1L);

        System.out.println(eating);
        return null;
    }
}
