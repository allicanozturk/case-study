package com.example.casestudy.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class FlightCreationRequest extends BaseRequest{
  @NotBlank(message = "departureDate can't be empty" )
  private String departureDate;
  @NotBlank(message = "departureDate can't be empty" )
  private String arrivalDate;
  @NotNull(message = "totalSeat can't be empty" )
  private Integer totalSeat;
  @NotNull(message = "price can't be empty" )
  private BigDecimal price;
  @NotNull(message = "airlineId can't be empty" )
  private Long airlineId;
  @NotNull(message = "routeId can't be empty" )
  private Long routeId;

  public String getDepartureDate() {
    return departureDate;
  }

  public void setDepartureDate(String departureDate) {
    this.departureDate = departureDate;
  }

  public String getArrivalDate() {
    return arrivalDate;
  }

  public void setArrivalDate(String arrivalDate) {
    this.arrivalDate = arrivalDate;
  }

  public Integer getTotalSeat() {
    return totalSeat;
  }

  public void setTotalSeat(Integer totalSeat) {
    this.totalSeat = totalSeat;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public Long getAirlineId() {
    return airlineId;
  }

  public void setAirlineId(Long airlineId) {
    this.airlineId = airlineId;
  }

  public Long getRouteId() {
    return routeId;
  }

  public void setRouteId(Long routeId) {
    this.routeId = routeId;
  }
}
