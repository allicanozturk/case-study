package com.example.casestudy.dto.request;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PaymentRequest extends BaseRequest {
  @NotNull
  private Long ticketId;
  @NotBlank(message = "cardNumber can't be empty")
  @Length(min = 19,max = 19)
  private String cardNumber;
  @NotBlank(message = "cvc can't be empty")
  private String cvc;
  @NotBlank(message = "expYear can't be empty")
  private String expYear;
  @NotBlank(message = "expMonth can't be empty")
  private String expMonth;

  public Long getTicketId() {
    return ticketId;
  }

  public void setTicketId(Long ticketId) {
    this.ticketId = ticketId;
  }

  public String getCardNumber() {
    return cardNumber;
  }

  public void setCardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
  }

  public String getCvc() {
    return cvc;
  }

  public void setCvc(String cvc) {
    this.cvc = cvc;
  }

  public String getExpYear() {
    return expYear;
  }

  public void setExpYear(String expYear) {
    this.expYear = expYear;
  }

  public String getExpMonth() {
    return expMonth;
  }

  public void setExpMonth(String expMonth) {
    this.expMonth = expMonth;
  }
}
