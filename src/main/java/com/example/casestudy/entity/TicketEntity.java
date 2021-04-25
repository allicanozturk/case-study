package com.example.casestudy.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "tickets")
public class TicketEntity extends  BaseEntity{


  private Long ticketId;
  private String ticketNumber;
  private String status;
  private BigDecimal price;
  private PassengerEntity passenger;
  private FlightEntity flight;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long getTicketId() {
    return ticketId;
  }

  public void setTicketId(Long ticketId) {
    this.ticketId = ticketId;
  }

  public String getTicketNumber() {
    return ticketNumber;
  }

  public void setTicketNumber(String ticketNumber) {
    this.ticketNumber = ticketNumber;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "passenger_id", referencedColumnName = "passenger_id")
  public PassengerEntity getPassenger() {
    return passenger;
  }

  public void setPassenger(PassengerEntity passenger) {
    this.passenger = passenger;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "flight_id", referencedColumnName = "flight_id")
  public FlightEntity getFlight() {
    return flight;
  }

  public void setFlight(FlightEntity flight) {
    this.flight = flight;
  }
}
