package com.rooney.james.msscbeerservice.web.mapper;

import com.rooney.james.msscbeerservice.domain.Beer;
import com.rooney.james.msscbeerservice.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = DateMapper.class)
public interface BeerMapper {
    BeerDto beerToBeerDto(Beer beer);
    Beer beerDtoToBeer(BeerDto beer);
}
