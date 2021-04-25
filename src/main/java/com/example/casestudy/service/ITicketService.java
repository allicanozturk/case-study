package com.example.casestudy.service;

import com.example.casestudy.dto.request.TicketCreationRequest;
import com.example.casestudy.dto.request.TicketUpdateRequest;
import com.example.casestudy.dto.model.Ticket;

public interface ITicketService {

  Ticket create(TicketCreationRequest request);

  Ticket fetch(String ticketNumber);

  Ticket cancel(TicketUpdateRequest request);
}
