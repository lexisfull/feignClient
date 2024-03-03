package ru.panov.feignclient.service;

import ru.panov.feignclient.client.DTO.EatingDTO;

import java.util.List;

public interface Calculate {

    public List<EatingDTO> calculateCalorie();
}
