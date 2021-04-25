package com.example.casestudy.dto.model;


import com.example.casestudy.dto.request.TicketCreationRequest;

public class Ticket extends TicketCreationRequest {

  private Long ticketId;
  private String ticketNumber;
  private String from;
  private String to;
  private String status;

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

  public String getFrom() {
    return from;
  }

  public void setFrom(String from) {
    this.from = from;
  }

  public String getTo() {
    return to;
  }

  public void setTo(String to) {
    this.to = to;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
