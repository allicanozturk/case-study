package com.example.casestudy.dto.request;


import javax.validation.constraints.NotEmpty;

public class AirportCreationRequest extends BaseRequest {

  @NotEmpty(message = "airportName can't be empty")
  private String airportName;
  @NotEmpty(message = "airportShortCode can't be empty")
  private String airportShortCode;
  @NotEmpty(message = "latitude can't be empty")
  private String latitude;
  @NotEmpty(message = "longitude can't be empty")
  private String longitude;
  @NotEmpty(message = "country can't be empty")
  private String country;
  @NotEmpty(message = "city can't be empty")
  private String city;


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
}
