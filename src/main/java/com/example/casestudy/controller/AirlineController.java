package com.example.casestudy.controller;

import com.example.casestudy.dto.request.AirlineCreationRequest;
import com.example.casestudy.dto.model.Airline;
import com.example.casestudy.dto.response.GenericResponse;
import com.example.casestudy.service.IAirlineService;
import com.example.casestudy.util.RequestPath;
import com.example.casestudy.validation.RequestValidation;
import com.example.casestudy.validation.validator.ValidatorPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = RequestPath.AIRLINE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class AirlineController {

  private final IAirlineService airlineService;

  @Autowired
  public AirlineController(IAirlineService airlineService) {
    this.airlineService = airlineService;
  }

  @PostMapping()
  @RequestValidation(validatorPath = ValidatorPath.AIRLINE_VALIDATOR)
  public ResponseEntity<GenericResponse<Airline>> createAirLine(@Validated @RequestBody AirlineCreationRequest request) {
    GenericResponse response = GenericResponse.createSuccessfulResponse(airlineService.create(request));
    return new ResponseEntity<>(response, HttpStatus.CREATED);
  }

  @GetMapping()
  public ResponseEntity<List<Airline>> fetchAirlines(@RequestParam(value = "name") String name) {
    List<Airline> airlines = airlineService.fetch(name);
    return CollectionUtils.isEmpty(airlines) ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(airlines, HttpStatus.OK);
  }

}
