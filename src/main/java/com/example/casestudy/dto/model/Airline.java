package com.example.casestudy.dto.model;

import com.example.casestudy.dto.request.AirlineCreationRequest;

public class Airline extends AirlineCreationRequest {

  private Long airlineId;

  public Long getAirlineId() {
    return airlineId;
  }

  public void setAirlineId(Long airlineId) {
    this.airlineId = airlineId;
  }

}
