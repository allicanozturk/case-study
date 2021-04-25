package com.example.casestudy.service.impl;

import com.example.casestudy.dto.model.Route;
import com.example.casestudy.dto.request.RouteCreationRequest;
import com.example.casestudy.entity.AirportEntity;
import com.example.casestudy.entity.RouteEntity;
import com.example.casestudy.repository.AirPortRepository;
import com.example.casestudy.repository.RouteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class CreateRouteTest {
  @Mock
  private RouteRepository routeRepository;
  @Mock
  private AirPortRepository airPortRepository;
  @InjectMocks
  private RouteServiceImpl routeService;

  @Test
  void whenCreatedRoute_thenReturnRouteObject(){
    RouteCreationRequest request = new RouteCreationRequest();
    request.setDepartureAirportId(1L);
    request.setArrivalAirportId(2L);

    AirportEntity departureAirport = new AirportEntity();
    departureAirport.setAirportId(1L);
    AirportEntity arrivalAirport = new AirportEntity();
    arrivalAirport.setAirportId(2L);
    List<AirportEntity> airportEntities = new ArrayList<>();
    airportEntities.add(departureAirport);
    airportEntities.add(arrivalAirport);
    RouteEntity routeEntity = new RouteEntity();
    routeEntity.setRouteId(1L);

    when(airPortRepository.findAllByAirportIdIn(Arrays.asList(request.getArrivalAirportId(), request.getDepartureAirportId())))
    .thenReturn(airportEntities);
    when(routeRepository.save(any(RouteEntity.class))).thenReturn(routeEntity);

    Route route = routeService.create(request);
    assertNotNull(route);
  }

}
