package com.example.casestudy.service.impl;

import com.example.casestudy.dto.model.Airline;
import com.example.casestudy.dto.model.Flight;
import com.example.casestudy.entity.FlightEntity;
import com.example.casestudy.repository.FlightRepository;
import com.example.casestudy.util.DateUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class FetchFlightTest {

  @Mock
  private FlightRepository flightRepository;
  @InjectMocks
  private FlightServiceImpl flightService;

  @Test
  void whenFlightExistAccordingToSearchCriteria_thenReturnFlightList() {
    FlightEntity flightEntity = new FlightEntity();
    flightEntity.setFlightId(1L);
    List<FlightEntity> flightEntities = new ArrayList<>();
    flightEntities.add(flightEntity);

    when(flightRepository.findFlightsByDateAndFromAndTo(any(),any(),any())).thenReturn(flightEntities);
    List<Flight> result = flightService.fetch("Sabiha Gökçen Havalimanı", "Sabiha Gökçen Havalimanı2", "2001-07-04T12:08:56");
    assertNotNull(result);
  }

  @Test
  void whenFlightNotExistAccordingToSearchCriteria_thenReturnEmptyList() {
    final List<Flight> expectedResult = Arrays.asList();
    when(flightRepository.findFlightsByDateAndFromAndTo(any(),any(),any())).thenReturn(null);
    List<Flight> result = flightService.fetch("Sabiha Gökçen Havalimanı", "Sabiha Gökçen Havalimanı2", "2001-07-04T12:08:56");
    assertEquals(expectedResult, result);
  }

}
