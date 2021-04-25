package com.example.casestudy.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "flights")
public class FlightEntity extends BaseEntity {

  private Long flightId;
  private Date departureDate;
  private Date arrivalDate;
  private Integer totalSeat;
  private Integer availableSeat;
  private BigDecimal salePrice;
  private RouteEntity route;
  private AirlineEntity airline;
  private String status;
  private BigDecimal basePrice;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "flight_id")
  public Long getFlightId() {
    return flightId;
  }

  public void setFlightId(Long flightId) {
    this.flightId = flightId;
  }


  public Date getDepartureDate() {
    return departureDate;
  }

  public void setDepartureDate(Date departureDate) {
    this.departureDate = departureDate;
  }

  public Date getArrivalDate() {
    return arrivalDate;
  }

  public void setArrivalDate(Date arrivalDate) {
    this.arrivalDate = arrivalDate;
  }

  public Integer getTotalSeat() {
    return totalSeat;
  }

  public void setTotalSeat(Integer totalSeat) {
    this.totalSeat = totalSeat;
  }

  public Integer getAvailableSeat() {
    return availableSeat;
  }

  public void setAvailableSeat(Integer availableSeat) {
    this.availableSeat = availableSeat;
  }

  public BigDecimal getSalePrice() {
    return salePrice;
  }

  public void setSalePrice(BigDecimal salePrice) {
    this.salePrice = salePrice;
  }

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "route_id", referencedColumnName = "route_id")
  public RouteEntity getRoute() {
    return route;
  }

  public void setRoute(RouteEntity route) {
    this.route = route;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "airline_id", referencedColumnName = "airline_id")
  public AirlineEntity getAirline() {
    return airline;
  }

  public void setAirline(AirlineEntity airline) {
    this.airline = airline;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public BigDecimal getBasePrice() {
    return basePrice;
  }

  public void setBasePrice(BigDecimal basePrice) {
    this.basePrice = basePrice;
  }
}
