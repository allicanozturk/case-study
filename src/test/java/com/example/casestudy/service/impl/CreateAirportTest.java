package com.example.casestudy.service.impl;

import com.example.casestudy.dto.model.Airport;
import com.example.casestudy.dto.request.AirportCreationRequest;
import com.example.casestudy.entity.AirportEntity;
import com.example.casestudy.repository.AirPortRepository;
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
public class CreateAirportTest {

  @Mock
  private AirPortRepository airPortRepository;
  @InjectMocks
  private AirportServiceImpl airportService;

  @Test
  public void whenCreatedAirport_ThenReturnAirportObject() {
    AirportCreationRequest request = new AirportCreationRequest();


    AirportEntity airportEntity = new AirportEntity();
    airportEntity.setActive(true);
    airportEntity.setAirportId(1L);
    airportEntity.setAirportName("Sabiha Gökçen Havalimanı");
    airportEntity.setAirportShortCode("SAG");
    airportEntity.setCity("İstanbul");
    airportEntity.setCountry("Türkiye");

    when(airPortRepository.save(any(AirportEntity.class))).thenReturn(airportEntity);
    Airport result = airportService.create(request);

    verify(airPortRepository, times(1)).save(any(AirportEntity.class));
    assertNotNull(result);
  }
}
