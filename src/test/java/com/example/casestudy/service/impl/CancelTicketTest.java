package com.example.casestudy.service.impl;

import com.example.casestudy.dto.model.Ticket;
import com.example.casestudy.dto.request.TicketUpdateRequest;
import com.example.casestudy.entity.TicketEntity;
import com.example.casestudy.exception.ResourceNotFoundException;
import com.example.casestudy.repository.TicketRepository;
import com.example.casestudy.util.GeneralEnumerationDefinition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class CancelTicketTest {

  @Mock
  private TicketRepository ticketRepository;
  @InjectMocks
  private TicketServiceImpl ticketService;


  private TicketUpdateRequest request;

  @BeforeEach
  void setup(){
    request = new TicketUpdateRequest();
    request.setTicketId(1L);
  }


  @Test
  void whenTicketExist_thenChangeStatus(){
    TicketEntity ticketEntity = new TicketEntity();
    ticketEntity.setTicketId(1L);
    ticketEntity.setStatus(GeneralEnumerationDefinition.TicketStatus.APPROVED.name());

    when(ticketRepository.findByTicketIdAndStatus(request.getTicketId(), GeneralEnumerationDefinition.TicketStatus.APPROVED.name()))
        .thenReturn(Optional.of(ticketEntity));
    ticketEntity.setStatus(GeneralEnumerationDefinition.TicketStatus.CANCEL.name());
    when(ticketRepository.save(any(TicketEntity.class))).thenReturn(ticketEntity);

    Ticket result = ticketService.cancel(request);
    assertEquals(GeneralEnumerationDefinition.TicketStatus.CANCEL.name(),result.getStatus());
  }

  @Test
  void whenTicketNotExist_thenThrowException(){
    when(ticketRepository.findByTicketIdAndStatus(request.getTicketId(), GeneralEnumerationDefinition.TicketStatus.APPROVED.name()))
        .thenReturn(Optional.empty());
    assertThrows(ResourceNotFoundException.class,()->ticketService.cancel(request));
  }

}
