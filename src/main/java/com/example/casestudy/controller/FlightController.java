package com.example.casestudy.controller;

import com.example.casestudy.dto.request.FlightCreationRequest;
import com.example.casestudy.dto.model.Flight;
import com.example.casestudy.dto.response.GenericResponse;
import com.example.casestudy.service.IFlightService;
import com.example.casestudy.util.RequestPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = RequestPath.FLIGHT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class FlightController {

  private final IFlightService flightService;

  @Autowired
  public FlightController(IFlightService flightService) {
    this.flightService = flightService;
  }

  @PostMapping()
  public ResponseEntity<GenericResponse<Flight>> createFlight(@Validated @RequestBody FlightCreationRequest request){
    GenericResponse response = GenericResponse.createSuccessfulResponse(flightService.create(request));
    return new ResponseEntity<>(response, HttpStatus.CREATED);
  }

  @GetMapping()
  public ResponseEntity<?> fetchFlights(@RequestParam String from, @RequestParam String to, @RequestParam String departureDate){
    List<Flight> flights = flightService.fetch(from, to, departureDate);
    return CollectionUtils.isEmpty(flights) ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(flights, HttpStatus.OK);
  }

}
