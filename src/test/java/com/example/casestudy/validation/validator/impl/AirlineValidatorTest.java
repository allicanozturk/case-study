package com.example.casestudy.validation.validator.impl;

import com.example.casestudy.dto.request.AirlineCreationRequest;
import com.example.casestudy.dto.request.AirportCreationRequest;

import com.example.casestudy.service.impl.AirlineServiceImpl;
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
public class AirlineValidatorTest {

  @Mock
  private AirlineServiceImpl airlineService;
  @InjectMocks
  private AirlineValidator airlineValidator;

  private final String shortCode = "PEG";
  private AirlineCreationRequest request =new AirlineCreationRequest();;

  @BeforeEach
  void setup() {
    request.setCompanyShortCode(shortCode);
  }

  @Test
  void whenAirlineExist_thenReturnFalse() {
    when(airlineService.isAirlineExist(shortCode)).thenReturn(true);
    boolean result = airlineValidator.validate(request);
    Assertions.assertFalse(result);
  }

  @Test
  void whenAirlineNotExist_thenReturnTrue() {
    when(airlineService.isAirlineExist(shortCode)).thenReturn(false);
    boolean result = airlineValidator.validate(request);
    Assertions.assertTrue(result);
  }

  @Test
  void whenRequestTypeIsNotAirlineCreationRequest_thenReturnFalse() {
    AirportCreationRequest invalidRequest = new AirportCreationRequest();
    boolean result = airlineValidator.validate(invalidRequest);
    Assertions.assertFalse(result);
  }

}
