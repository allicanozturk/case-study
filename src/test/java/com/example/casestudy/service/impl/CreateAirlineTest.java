package com.example.casestudy.service.impl;

import com.example.casestudy.dto.request.AirlineCreationRequest;
import com.example.casestudy.dto.model.Airline;
import com.example.casestudy.entity.AirlineEntity;
import com.example.casestudy.repository.AirlineRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class CreateAirlineTest {

  @Mock
  private AirlineRepository airlineRepository;
  @InjectMocks
  private AirlineServiceImpl airlineService;


  @Test
  public void whenCreatedAirline_ThenReturnAirlineObject() {
    AirlineCreationRequest request = new AirlineCreationRequest();
    request.setWebSiteUrl("www.pegasus.com");
    request.setCompanyShortCode("PGS");
    request.setEmail("info@pegasus.com");
    request.setCompanyName("Pegasus");

    AirlineEntity airlineEntity = new AirlineEntity();
    airlineEntity.setAirlineId(1L);
    airlineEntity.setCompanyShortCode("PEG");
    airlineEntity.setCompanyName("PEGASUS");
    airlineEntity.setEmail("info@pegasus.com");
    airlineEntity.setWebSiteUrl("www.pegasus.com");


    when(airlineRepository.save(any(AirlineEntity.class))).thenReturn(airlineEntity);
    Airline result = airlineService.create(request);

    verify(airlineRepository, times(1)).save(any(AirlineEntity.class));
    assertNotNull(result);
  }


}
