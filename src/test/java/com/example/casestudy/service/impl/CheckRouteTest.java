package com.example.casestudy.service.impl;
import com.example.casestudy.entity.RouteEntity;
import com.example.casestudy.repository.RouteRepository;
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

public class CheckRouteTest {

  @Mock
  private RouteRepository routeRepository;
  @InjectMocks
  private RouteServiceImpl routeService;

  @Test
  void whenRouteExist_thenReturnTrue(){
    RouteEntity routeEntity = new RouteEntity();
    when(routeRepository.findByFromAirportIdAndToAirportIdAndActive(1L,2L,true)).thenReturn(routeEntity);
    boolean result = routeService.isRouteExist(1L, 2L);
    assertTrue(result);
  }

  @Test
  void whenRouteNotExist_thenReturnFalse(){
    when(routeRepository.findByFromAirportIdAndToAirportIdAndActive(1L,2L,true)).thenReturn(null);
    boolean result = routeService.isRouteExist(1L, 2L);
    assertFalse(result);
  }

}
