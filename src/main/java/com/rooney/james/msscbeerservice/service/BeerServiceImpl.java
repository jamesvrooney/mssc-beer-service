package com.rooney.james.msscbeerservice.service;

import com.rooney.james.msscbeerservice.domain.Beer;
import com.rooney.james.msscbeerservice.exception.BeerNotFoundException;
import com.rooney.james.msscbeerservice.repository.BeerRepository;
import com.rooney.james.msscbeerservice.web.mapper.BeerMapper;
import com.rooney.james.msscbeerservice.web.model.BeerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class BeerServiceImpl implements BeerService {

    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper;

    @Override
    public BeerDto getById(UUID beerId) {
        Beer beer = beerRepository.findById(beerId).orElseThrow(BeerNotFoundException::new);

        BeerDto beerDto = beerMapper.beerToBeerDto(beer);

        return beerDto;
    }

    @Override
    public BeerDto saveNewBeer(BeerDto newBeer) {
        Beer beerToBeSaved = beerMapper.beerDtoToBeer(newBeer);

        Beer savedBeer = beerRepository.save(beerToBeSaved);

        BeerDto savedBeerDto = beerMapper.beerToBeerDto(savedBeer);

        return savedBeerDto;
    }

    @Override
    public BeerDto updateBeer(UUID beerId, BeerDto beerDto) {
        Beer beer = beerRepository.findById(beerId).orElseThrow(BeerNotFoundException::new);

        beer.setBeerName(beerDto.getBeerName());
        beer.setBeerStyle(beerDto.getBeerStyle());
        beer.setPrice(beerDto.getPrice());
        beer.setUpc(beerDto.getUpc());

        return beerMapper.beerToBeerDto(beerRepository.save(beer));
    }
}
