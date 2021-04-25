package com.example.casestudy.dto.event;

import org.springframework.context.ApplicationEvent;

public class AfterPaymentEvent  extends ApplicationEvent {
  private Long ticketId;

  public AfterPaymentEvent(Object source, Long ticketId) {
    super(source);
    this.ticketId = ticketId;
  }

  public Long getTicketId() {
    return ticketId;
  }

  public void setTicketId(Long ticketId) {
    this.ticketId = ticketId;
  }
}
