package com.rooney.james.msscbeerservice.web.controller;

import com.rooney.james.msscbeerservice.web.model.BeerDto;
import com.rooney.james.msscbeerservice.web.model.BeerStyle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.UUID;

@Slf4j
@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeerById(@PathVariable UUID beerId) {
        log.info("Getting a beer with id: {}", beerId);

        BeerDto beer = BeerDto.builder()
                .beerName("Guinness")
                .beerStyle(BeerStyle.ALE)
                .version(1)
                .price(new BigDecimal(3.45))
                .build();

        // TODO: implement
        return new ResponseEntity<>(beer, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveNewBeer(@RequestBody BeerDto newBeer) {
        // TODO: implement
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/beer/" + UUID.randomUUID());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity updateBeerById(@PathVariable UUID beerId, @RequestBody BeerDto newBeer) {
        // TODO: implement
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
