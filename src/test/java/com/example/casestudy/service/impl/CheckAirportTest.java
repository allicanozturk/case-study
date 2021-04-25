package com.example.casestudy.service.impl;

import com.example.casestudy.entity.AirlineEntity;
import com.example.casestudy.entity.AirportEntity;
import com.example.casestudy.repository.AirPortRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class CheckAirportTest {


  @Mock
  private AirPortRepository airPortRepository;
  @InjectMocks
  private AirportServiceImpl airportService;

  private final String shortCode="SAG";

  @Test
  void whenAirlineExist_thenReturnTrue(){
    AirportEntity airportEntity = new AirportEntity();
    airportEntity.setAirportId(1L);

    when(airPortRepository.findByAirportShortCodeAndActive(shortCode,true)).thenReturn(airportEntity);
    boolean result = airportService.isAirportExist(shortCode);
    assertTrue(result);
  }

  @Test
  void whenAirlineExist_thenReturnFalse(){
    when(airPortRepository.findByAirportShortCodeAndActive(shortCode,true)).thenReturn(null);
    boolean result = airportService.isAirportExist(shortCode);
    assertFalse(result);
  }

}
