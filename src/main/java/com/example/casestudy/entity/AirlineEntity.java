package com.example.casestudy.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="airlines")
public class AirlineEntity extends BaseEntity{

  private Long airlineId;
  private String companyName;
  private String companyShortCode;
  private String email;
  private String webSiteUrl;
  private boolean isActive;
  private List<FlightEntity> flights = new ArrayList<>();

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "airline_id")
  public Long getAirlineId() {
    return airlineId;
  }

  public void setAirlineId(Long airlineId) {
    this.airlineId = airlineId;
  }

  public String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  public String getCompanyShortCode() {
    return companyShortCode;
  }

  public void setCompanyShortCode(String companyShortCode) {
    this.companyShortCode = companyShortCode;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getWebSiteUrl() {
    return webSiteUrl;
  }

  public void setWebSiteUrl(String webSiteUrl) {
    this.webSiteUrl = webSiteUrl;
  }

  @Column(name = "is_active")
  public boolean isActive() {
    return isActive;
  }

  public void setActive(boolean active) {
    isActive = active;
  }

  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "airline")
  public List<FlightEntity> getFlights() {
    return flights;
  }

  public void setFlights(List<FlightEntity> flights) {
    this.flights = flights;
  }
}
