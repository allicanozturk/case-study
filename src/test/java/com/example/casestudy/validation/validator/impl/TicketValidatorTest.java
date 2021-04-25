package com.example.casestudy.validation.validator.impl;

import com.example.casestudy.dto.request.AirportCreationRequest;
import com.example.casestudy.dto.request.TicketCreationRequest;
import com.example.casestudy.entity.FlightEntity;
import com.example.casestudy.repository.FlightRepository;
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

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class TicketValidatorTest {


  @Mock
  private FlightRepository flightRepository;
  @InjectMocks
  private TicketValidator ticketValidator;

  final TicketCreationRequest request = new TicketCreationRequest();

  @BeforeEach
  void setup() {
    request.setFlightId(1L);
  }

  @Test
  void whenFlightNotExist_thenReturnFalse() {
    when(flightRepository.findByFlightId(request.getFlightId())).thenReturn(null);
    boolean result = ticketValidator.validate(request);
    Assertions.assertFalse(result);
  }

  @Test
  void whenFlightNotActive_thenReturnFalse() {
    final FlightEntity flightEntity = new FlightEntity();
    flightEntity.setStatus(GeneralEnumerationDefinition.FlightStatus.POSTPONE.name());

    when(flightRepository.findByFlightId(request.getFlightId())).thenReturn(flightEntity);
    boolean result = ticketValidator.validate(request);
    Assertions.assertFalse(result);
  }

  @Test
  void whenAvailableSeatNotExist_thenReturnFalse() {
    final FlightEntity flightEntity = new FlightEntity();
    flightEntity.setStatus(GeneralEnumerationDefinition.FlightStatus.ACTIVE.name());
    flightEntity.setAvailableSeat(0);

    when(flightRepository.findByFlightId(request.getFlightId())).thenReturn(flightEntity);
    boolean result = ticketValidator.validate(request);
    Assertions.assertFalse(result);
  }

  @Test
  void whenRequestTypeIsNotTicketCreationRequest_thenReturnFalse() {
    AirportCreationRequest invalidRequest = new AirportCreationRequest();
    boolean result = ticketValidator.validate(invalidRequest);
    Assertions.assertFalse(result);
  }

  @Test
  void whenThereIsActiveFlightAndAvailableSeatGraterThanZero_thenReturnTrue() {
    final FlightEntity flightEntity = new FlightEntity();
    flightEntity.setStatus(GeneralEnumerationDefinition.FlightStatus.ACTIVE.name());
    flightEntity.setAvailableSeat(90);

    when(flightRepository.findByFlightId(request.getFlightId())).thenReturn(flightEntity);
    boolean result = ticketValidator.validate(request);
    Assertions.assertTrue(result);
  }


}
