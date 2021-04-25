package com.example.casestudy.dto.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class TicketCreationRequest extends BaseRequest {
  @NotNull
  private Long flightId;
  @NotEmpty (message = "name can't be empty")
  private String name;
  @NotEmpty (message = "surname can't be empty")
  private String surname;
  @NotEmpty (message = "identityNumber can't be empty")
  private String identityNumber;
  @NotEmpty (message = "email can't be empty")
  private String email;

  public Long getFlightId() {
    return flightId;
  }

  public void setFlightId(Long flightId) {
    this.flightId = flightId;
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
}
