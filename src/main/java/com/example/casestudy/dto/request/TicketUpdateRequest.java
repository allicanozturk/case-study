package com.example.casestudy.dto.request;

import javax.validation.constraints.NotNull;


public class TicketUpdateRequest extends BaseRequest {

  @NotNull
  private Long ticketId;

  public Long getTicketId() {
    return ticketId;
  }

  public void setTicketId(Long ticketId) {
    this.ticketId = ticketId;
  }

}
