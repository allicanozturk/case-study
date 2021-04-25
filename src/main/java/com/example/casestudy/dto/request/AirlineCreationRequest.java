package com.example.casestudy.dto.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class AirlineCreationRequest extends BaseRequest {
  @NotEmpty(message = "companyName can't be empty")
  private String companyName;
  @NotEmpty(message = "companyShortCode can't be empty")
  private String companyShortCode;
  @Email
  private String email;
  @NotEmpty(message = "companyShortCode can't be empty")
  private String webSiteUrl;

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
}
