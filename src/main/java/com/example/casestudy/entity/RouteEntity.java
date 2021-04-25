package com.example.casestudy.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "routes")
public class RouteEntity extends BaseEntity {


  private Long routeId;
  private Long fromAirportId;
  private Long toAirportId;
  private AirportEntity from;
  private AirportEntity to;
  private boolean isActive;
  private List<FlightEntity> flights = new ArrayList<>();

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "route_id")
  public Long getRouteId() {
    return routeId;
  }

  public void setRouteId(Long routeId) {
    this.routeId = routeId;
  }

  @Column(name = "from_airport_id")
  public Long getFromAirportId() {
    return fromAirportId;
  }

  public void setFromAirportId(Long fromAirportId) {
    this.fromAirportId = fromAirportId;
  }

  @Column(name = "to_airport_id")
  public Long getToAirportId() {
    return toAirportId;
  }

  public void setToAirportId(Long toAirportId) {
    this.toAirportId = toAirportId;
  }

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "from_airport_id", referencedColumnName = "airport_id",insertable = false,updatable = false)
  public AirportEntity getFrom() {
    return from;
  }

  public void setFrom(AirportEntity from) {
    this.from = from;
  }

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "to_airport_id", referencedColumnName = "airport_id",insertable = false, updatable = false)
  public AirportEntity getTo() {
    return to;
  }

  public void setTo(AirportEntity to) {
    this.to = to;
  }

  @Column(name = "is_active")
  public boolean isActive() {
    return isActive;
  }

  public void setActive(boolean active) {
    isActive = active;
  }

  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "route")
  public List<FlightEntity> getFlights() {
    return flights;
  }

  public void setFlights(List<FlightEntity> flights) {
    this.flights = flights;
  }


}
