package com.example.casestudy.service.impl;

import com.example.casestudy.dto.model.Ticket;
import com.example.casestudy.entity.TicketEntity;
import com.example.casestudy.repository.TicketRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class FetchTicketTest {

  @Mock
  private TicketRepository ticketRepository;
  @InjectMocks
  private TicketServiceImpl ticketService;

  private final String ticketNumber = "ABC_123";

  @Test
  void whenTicketExist_thenReturnTicket() {
    TicketEntity ticketEntity = new TicketEntity();
    ticketEntity.setTicketId(1L);

    when(ticketRepository.findByTicketNumber(ticketNumber)).thenReturn(ticketEntity);
    Ticket result = ticketService.fetch(ticketNumber);
    assertNotNull(result);
  }

  @Test
  void whenTicketNotExist_thenReturnNull() {
    when(ticketRepository.findByTicketNumber(ticketNumber)).thenReturn(null);
    Ticket result = ticketService.fetch(ticketNumber);
    assertNull(result);
  }

}
