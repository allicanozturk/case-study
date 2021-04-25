package com.example.casestudy.entity;

import javax.persistence.*;

@Entity
public class PaymentEntity extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long paymentId;
  private String cardNumber;
  private String transactionNumber;
  private Long ticketId;


  public Long getPaymentId() {
    return paymentId;
  }

  public void setPaymentId(Long paymentId) {
    this.paymentId = paymentId;
  }

  public String getCardNumber() {
    return cardNumber;
  }

  public void setCardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
  }


  public String getTransactionNumber() {
    return transactionNumber;
  }

  public void setTransactionNumber(String transactionNumber) {
    this.transactionNumber = transactionNumber;
  }

  public Long getTicketId() {
    return ticketId;
  }

  public void setTicketId(Long ticketId) {
    this.ticketId = ticketId;
  }
}
