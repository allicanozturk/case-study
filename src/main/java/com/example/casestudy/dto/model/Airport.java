package com.example.casestudy.dto.model;

import com.example.casestudy.dto.request.AirportCreationRequest;

public class Airport extends AirportCreationRequest {
  private Long airportId;

  public Long getAirportId() {
    return airportId;
  }

  public void setAirportId(Long airportId) {
    this.airportId = airportId;
  }
}
