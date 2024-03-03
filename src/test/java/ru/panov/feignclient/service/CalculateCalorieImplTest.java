package ru.panov.feignclient.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.http.ResponseEntity;
import ru.panov.feignclient.client.DTO.EatingDTO;

import java.util.ArrayList;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.*;


@AutoConfigureWireMock(port = 0)
@SpringBootTest
class CalculateCalorieImplTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private CalculateCalorieImpl calculateCalorie;
    @Test
    void should_CalculateCalorie_Test() throws JsonProcessingException {
        EatingDTO eatingDTO1 = EatingDTO.builder()
                .id(1L)
                .personId(1L)
                .build();
        List<EatingDTO> eatingDTOList = List.of(eatingDTO1);
        stubFor(get(urlPathEqualTo("/eating/1"))
                .willReturn(okJson(objectMapper.writeValueAsString(eatingDTOList))));

        var eating = calculateCalorie.calculateCalorie();

        Assertions.assertEquals(List.of(eatingDTO1), eating);

    }
}