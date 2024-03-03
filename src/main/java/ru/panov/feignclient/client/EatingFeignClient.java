package ru.panov.feignclient.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.panov.feignclient.client.DTO.EatingDTO;

import java.util.List;

@FeignClient(name = "eatClient", url = "${client.url}")
public interface EatingFeignClient {

    @GetMapping("/{personId}")
    ResponseEntity<List<EatingDTO>> getEatingPersonId(@PathVariable Long personId);
}
