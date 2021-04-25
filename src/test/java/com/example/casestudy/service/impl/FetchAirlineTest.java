package com.example.casestudy.service.impl;

import com.example.casestudy.dto.model.Airline;
import com.example.casestudy.entity.AirlineEntity;
import com.example.casestudy.repository.AirlineRepository;
import com.example.casestudy.util.DateUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class FetchAirlineTest {

  @Mock
  private AirlineRepository airlineRepository;
  @InjectMocks
  private AirlineServiceImpl airlineService;

  private final String searchKeyword="PEG";


  @Test
  void whenAirlineExist_thenReturnAirlineList() {
    AirlineEntity airlineEntity = new AirlineEntity();
    airlineEntity.setAirlineId(1L);
    airlineEntity.setCompanyShortCode("PEG");
    airlineEntity.setCompanyName("PEGASUS");
    airlineEntity.setEmail("info@pegasus.com");
    airlineEntity.setWebSiteUrl("www.pegasus.com");

    when(airlineRepository.findAllByCompanyNameLike('%' + searchKeyword + '%')).thenReturn(Arrays.asList(airlineEntity));
    List<Airline> result = airlineService.fetch(searchKeyword);

    verify(airlineRepository, times(1)).findAllByCompanyNameLike('%' + searchKeyword + '%');
    assertNotNull(result);
  }

  @Test
  void whenAirlineNotExist_thenReturnEmptyList() {
    final List<Airline> expectedResult = Arrays.asList();

    when(airlineRepository.findAllByCompanyNameLike('%' + searchKeyword + '%')).thenReturn(null);
    List<Airline> result = airlineService.fetch(searchKeyword);

    verify(airlineRepository, times(1)).findAllByCompanyNameLike('%' + searchKeyword + '%');
    assertEquals(expectedResult, result);
  }


}
