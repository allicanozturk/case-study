package com.example.casestudy.service;

import com.example.casestudy.dto.request.FlightCreationRequest;
import com.example.casestudy.dto.model.Flight;

import java.util.List;

public interface IFlightService {

  Flight create(FlightCreationRequest request);

 List<Flight>  fetch (String from, String to, String departureDate);
}
