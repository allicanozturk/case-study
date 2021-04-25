package com.example.casestudy.dto.model;

import com.example.casestudy.dto.request.FlightCreationRequest;

public class Flight extends FlightCreationRequest {
  private Long flightId;
  private Integer availableSeat;
  private String  airlineName;
  private String  from;
  private String  to;


  public Long getFlightId() {
    return flightId;
  }

  public void setFlightId(Long flightId) {
    this.flightId = flightId;
  }

  public Integer getAvailableSeat() {
    return availableSeat;
  }

  public void setAvailableSeat(Integer availableSeat) {
    this.availableSeat = availableSeat;
  }

  public String getAirlineName() {
    return airlineName;
  }

  public void setAirlineName(String airlineName) {
    this.airlineName = airlineName;
  }

  public String getFrom() {
    return from;
  }

  public void setFrom(String from) {
    this.from = from;
  }

  public String getTo() {
    return to;
  }

  public void setTo(String to) {
    this.to = to;
  }

}
