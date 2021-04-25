package com.example.casestudy.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "passengers")
public class PassengerEntity extends BaseEntity {

  private Long passengerId;
  private String name;
  private String surname;
  private String identityNumber;
  private String email;
  private List<TicketEntity> tickets = new ArrayList<>();

  @Override
  protected Object clone() throws CloneNotSupportedException {
    return super.clone();
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "passenger_id")
  public Long getPassengerId() {
    return passengerId;
  }

  public void setPassengerId(Long passengerId) {
    this.passengerId = passengerId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getIdentityNumber() {
    return identityNumber;
  }

  public void setIdentityNumber(String identityNumber) {
    this.identityNumber = identityNumber;
  }


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "passenger")
  public List<TicketEntity> getTickets() {
    return tickets;
  }

  public void setTickets(List<TicketEntity> tickets) {
    this.tickets = tickets;
  }

}
