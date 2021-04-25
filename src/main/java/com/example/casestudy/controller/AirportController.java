package com.example.casestudy.controller;

import com.example.casestudy.dto.request.AirportCreationRequest;
import com.example.casestudy.dto.model.Airport;
import com.example.casestudy.dto.response.GenericResponse;
import com.example.casestudy.service.IAirportService;
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
@RequestMapping(value = RequestPath.AIRPORT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class AirportController {

  private final IAirportService airportService;

  @Autowired
  public AirportController(IAirportService airportService) {
    this.airportService = airportService;
  }

  @PostMapping()
  @RequestValidation(validatorPath = ValidatorPath.AIRPORT_VALIDATOR)
  public ResponseEntity<GenericResponse<Airport>>createAirport(@Validated @RequestBody AirportCreationRequest request){
    GenericResponse response = GenericResponse.createSuccessfulResponse(airportService.create(request));
    return new ResponseEntity<>(response, HttpStatus.CREATED);
  }

  @GetMapping()
  public ResponseEntity<List<Airport>> fetchAirports(@RequestParam(value = "name") String name) {
    List<Airport> airports = airportService.fetch(name);
    return CollectionUtils.isEmpty(airports) ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(airports, HttpStatus.OK);
  }


}
