package com.example.casestudy.validation.validator.impl;

import com.example.casestudy.dto.request.AirportCreationRequest;
import com.example.casestudy.dto.request.RouteCreationRequest;
import com.example.casestudy.service.impl.RouteServiceImpl;
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
public class RouteValidatorTest {

  @Mock
  private RouteServiceImpl routeService;
  @InjectMocks
  private RouteValidator routeValidator;

  private RouteCreationRequest request = new RouteCreationRequest();

  @BeforeEach
  void setup() {
    request.setDepartureAirportId(1L);
    request.setArrivalAirportId(2L);
  }

  @Test
  void whenDepartureAirportIdEqualsArrivalAirportId_thenReturnFalse() {
    request.setArrivalAirportId(1L);
    boolean result = routeValidator.validate(request);
    Assertions.assertFalse(result);
  }

  @Test
  void whenRouteExist_thenReturnFalse() {
    when(routeService.isRouteExist(request.getDepartureAirportId(), request.getArrivalAirportId())).thenReturn(true);
    boolean result = routeValidator.validate(request);
    Assertions.assertFalse(result);
  }

  @Test
  void whenRouteNotExist_thenReturnTrue() {
    when(routeService.isRouteExist(request.getDepartureAirportId(), request.getArrivalAirportId())).thenReturn(false);
    boolean result = routeValidator.validate(request);
    Assertions.assertTrue(result);
  }

 @Test
 void whenRequestTypeIsNotRouteCreationRequest_thenReturnFalse() {
   AirportCreationRequest invalidRequest = new AirportCreationRequest();
   boolean result = routeValidator.validate(invalidRequest);
   Assertions.assertFalse(result);
 }

}
