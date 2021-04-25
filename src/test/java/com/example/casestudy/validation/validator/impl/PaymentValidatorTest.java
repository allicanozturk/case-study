package com.example.casestudy.validation.validator.impl;

import com.example.casestudy.dto.request.AirportCreationRequest;
import com.example.casestudy.dto.request.PaymentRequest;
import com.example.casestudy.entity.TicketEntity;
import com.example.casestudy.repository.TicketRepository;
import com.example.casestudy.util.GeneralEnumerationDefinition;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class PaymentValidatorTest {

  @Mock
  private TicketRepository ticketRepository;
  @InjectMocks
  private PaymentValidator paymentValidator;

  private final PaymentRequest request = new PaymentRequest();
  private final TicketEntity ticketEntity = new TicketEntity();

  @BeforeEach
  void setup(){
    request.setTicketId(1L);
  }

  @Test
  void whenTicketNotExist_thenReturnFalse() {
    when(ticketRepository.findById(request.getTicketId())).thenReturn(Optional.empty());
    boolean result = paymentValidator.validate(request);
    assertFalse(result);
  }

  @Test
  void whenTicketStatusNotEqualsPending_thenReturnFalse() {
    ticketEntity.setStatus(GeneralEnumerationDefinition.TicketStatus.CANCEL.name());
    when(ticketRepository.findById(request.getTicketId())).thenReturn(Optional.of(ticketEntity));
    boolean result = paymentValidator.validate(request);
    assertFalse(result);
  }

  @Test
  void whenTicketStatusPending_thenReturnTrue() {
    ticketEntity.setStatus(GeneralEnumerationDefinition.TicketStatus.PENDING.name());
    when(ticketRepository.findById(request.getTicketId())).thenReturn(Optional.of(ticketEntity));
    boolean result = paymentValidator.validate(request);
    assertTrue(result);
  }

  @Test
  void whenRequestTypeIsNotPaymentRequest_thenReturnFalse() {
    AirportCreationRequest invalidRequest = new AirportCreationRequest();
    boolean result = paymentValidator.validate(invalidRequest);
    assertFalse(result);
  }

}
