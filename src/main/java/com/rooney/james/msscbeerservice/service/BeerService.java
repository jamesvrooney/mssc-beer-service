package com.rooney.james.msscbeerservice.service;

import com.rooney.james.msscbeerservice.web.model.BeerDto;

import java.util.UUID;

public interface BeerService {
    BeerDto getById(UUID beerId);

    BeerDto saveNewBeer(BeerDto newBeer);

    BeerDto updateBeer(UUID beerId, BeerDto beerDto);
}
