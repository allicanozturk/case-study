package com.example.casestudy.entity;
import javax.persistence.*;


@Entity
@Table(name = "airports")
public class AirportEntity extends BaseEntity {

  private Long airportId;
  private String airportName;
  private String airportShortCode;
  private String latitude;
  private String longitude;
  private String country;
  private String city;
  private boolean isActive;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "airport_id")
  public Long getAirportId() {
    return airportId;
  }

  public void setAirportId(Long airportId) {
    this.airportId = airportId;
  }

  public String getAirportName() {
    return airportName;
  }

  public void setAirportName(String airportName) {
    this.airportName = airportName;
  }

  public String getAirportShortCode() {
    return airportShortCode;
  }

  public void setAirportShortCode(String airportShortCode) {
    this.airportShortCode = airportShortCode;
  }

  public String getLatitude() {
    return latitude;
  }

  public void setLatitude(String latitude) {
    this.latitude = latitude;
  }

  public String getLongitude() {
    return longitude;
  }

  public void setLongitude(String longitude) {
    this.longitude = longitude;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  @Column(name = "is_active")
  public boolean isActive() {
    return isActive;
  }

  public void setActive(boolean active) {
    isActive = active;
  }

}
