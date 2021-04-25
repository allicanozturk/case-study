package com.example.casestudy.service.impl;

import com.example.casestudy.dto.model.Flight;
import com.example.casestudy.dto.request.FlightCreationRequest;
import com.example.casestudy.entity.AirlineEntity;
import com.example.casestudy.entity.FlightEntity;
import com.example.casestudy.entity.RouteEntity;
import com.example.casestudy.repository.AirlineRepository;
import com.example.casestudy.repository.FlightRepository;
import com.example.casestudy.repository.RouteRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class CreateFlightTest {

  @Mock
  private AirlineRepository airlineRepository;
  @Mock
  private RouteRepository routeRepository;
  @Mock
  private FlightRepository flightRepository;
  @InjectMocks
  private FlightServiceImpl flightService;

  @Test
  void whenFlightCreated_thenReturnFlightObject() {
    FlightCreationRequest request = new FlightCreationRequest();
    request.setAirlineId(1L);
    request.setRouteId(1L);
    AirlineEntity airlineEntity = new AirlineEntity();
    airlineEntity.setAirlineId(1L);
    RouteEntity routeEntity = new RouteEntity();
    routeEntity.setRouteId(1L);
    FlightEntity flightEntity = new FlightEntity();
    flightEntity.setRoute(routeEntity);
    flightEntity.setAirline(airlineEntity);

    when(airlineRepository.findById(any())).thenReturn(Optional.ofNullable(airlineEntity));
    when(routeRepository.findById(any())).thenReturn(Optional.ofNullable(routeEntity));
    when(flightRepository.save(any(FlightEntity.class))).thenReturn(flightEntity);

    Flight result = flightService.create(request);
    Assertions.assertNotNull(result);
  }

}
