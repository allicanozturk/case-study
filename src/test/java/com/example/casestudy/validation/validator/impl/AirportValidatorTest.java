package com.example.casestudy.validation.validator.impl;

import com.example.casestudy.dto.request.AirlineCreationRequest;
import com.example.casestudy.dto.request.AirportCreationRequest;
import com.example.casestudy.service.impl.AirportServiceImpl;
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
public class AirportValidatorTest {

  @Mock
  private AirportServiceImpl airportService;
  @InjectMocks
  private AirportValidator airportValidator;

  private AirportCreationRequest request = new AirportCreationRequest();
  private final String airportShortCode = "SAG";

  @BeforeEach
  void setup() {
    request.setAirportShortCode(airportShortCode);
  }

  @Test
  void whenAirportExist_thenReturnFalse() {
    when(airportService.isAirportExist(airportShortCode)).thenReturn(true);
    boolean result = airportValidator.validate(request);
    Assertions.assertFalse(result);
  }

  @Test
  void whenAirlineNotExist_thenReturnTrue() {
    when(airportService.isAirportExist(airportShortCode)).thenReturn(false);
    boolean result = airportValidator.validate(request);
    Assertions.assertTrue(result);
  }

  @Test
  void whenRequestTypeIsNotAirportCreationRequest_thenReturnFalse() {
    AirlineCreationRequest invalidRequest = new AirlineCreationRequest();
    boolean result = airportValidator.validate(invalidRequest);
    Assertions.assertFalse(result);
  }


}
