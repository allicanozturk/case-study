package com.example.casestudy.service.impl;

import com.example.casestudy.entity.AirlineEntity;
import com.example.casestudy.repository.AirlineRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class CheckAirlineTest {


  @Mock
  private AirlineRepository airlineRepository;
  @InjectMocks
  private AirlineServiceImpl airlineService;

  private final String shortCode="PEG";

  @Test
  void whenAirlineExist_thenReturnTrue(){
    AirlineEntity airlineEntity = new AirlineEntity();
    airlineEntity.setAirlineId(1L);

    when(airlineRepository.findByCompanyShortCodeAndActive(shortCode,true)).thenReturn(airlineEntity);
    boolean result = airlineService.isAirlineExist(shortCode);
    assertTrue(result);
  }

  @Test
  void whenAirlineExist_thenReturnFalse(){
    when(airlineRepository.findByCompanyShortCodeAndActive(shortCode,true)).thenReturn(null);
    boolean result = airlineService.isAirlineExist(shortCode);
    assertFalse(result);
  }

}
