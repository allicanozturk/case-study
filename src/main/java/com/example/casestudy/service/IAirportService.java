package com.example.casestudy.service;

import com.example.casestudy.dto.request.AirportCreationRequest;
import com.example.casestudy.dto.model.Airport;

import java.util.List;


public interface IAirportService {

   Airport create(AirportCreationRequest airportCreationRequest);

   List<Airport> fetch(String searchKeyWord);

   boolean isAirportExist(final String airportShortCode);
}
