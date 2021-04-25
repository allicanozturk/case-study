package com.example.casestudy.service.impl;

import com.example.casestudy.dto.model.Airline;
import com.example.casestudy.dto.model.Airport;
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

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class FetchAirportTest {

  @Mock
  private AirPortRepository airPortRepository;
  @InjectMocks
  private AirportServiceImpl airportService;

  private final String searchKeyword ="Sabiha Gökçen";

  @Test
  void whenAirportExist_thenReturnAirportList() {
    AirportEntity airportEntity = new AirportEntity();
    airportEntity.setActive(true);
    airportEntity.setAirportId(1L);
    airportEntity.setAirportName("Sabiha Gökçen Havalimanı");
    airportEntity.setAirportShortCode("SAG");
    airportEntity.setCity("İstanbul");
    airportEntity.setCountry("Türkiye");

    when(airPortRepository.findAllByAirportNameLike('%' + searchKeyword + '%')).thenReturn(Arrays.asList(airportEntity));
    List<Airport> result = airportService.fetch(searchKeyword);

    verify(airPortRepository, times(1)).findAllByAirportNameLike('%' + searchKeyword + '%');
    assertNotNull(result);
  }

 @Test
 void whenAirportNotExist_thenReturnEmptyList() {
   final List<Airline> expectedResult = Arrays.asList();

   when(airPortRepository.findAllByAirportNameLike('%' + searchKeyword + '%')).thenReturn(null);
   List<Airport> result = airportService.fetch(searchKeyword);

   verify(airPortRepository, times(1)).findAllByAirportNameLike('%' + searchKeyword + '%');
   assertEquals(expectedResult, result);
 }

}
