package com.example.casestudy.service;

import com.example.casestudy.dto.request.AirlineCreationRequest;
import com.example.casestudy.dto.model.Airline;

import java.util.List;

public interface IAirlineService {

  Airline create(AirlineCreationRequest request);

  List<Airline> fetch(String searchKeyWord);

  boolean isAirlineExist(final  String airlineShortCode);

}
