package com.example.casestudy.dto.request;

import javax.validation.constraints.NotNull;

public class RouteCreationRequest extends BaseRequest {
  @NotNull
  private Long departureAirportId;
  @NotNull
  private Long arrivalAirportId;

  public Long getDepartureAirportId() {
    return departureAirportId;
  }

  public void setDepartureAirportId(Long departureAirportId) {
    this.departureAirportId = departureAirportId;
  }

  public Long getArrivalAirportId() {
    return arrivalAirportId;
  }

  public void setArrivalAirportId(Long arrivalAirportId) {
    this.arrivalAirportId = arrivalAirportId;
  }
}
