package com.example.casestudy.service.impl;

import com.example.casestudy.dto.request.AirportCreationRequest;
import com.example.casestudy.dto.model.Airport;
import com.example.casestudy.entity.AirportEntity;
import com.example.casestudy.mapper.AirportEntityMapper;
import com.example.casestudy.repository.AirPortRepository;
import com.example.casestudy.service.IAirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class AirportServiceImpl implements IAirportService {

  private final AirPortRepository airPortRepository;

  @Autowired
  public AirportServiceImpl(AirPortRepository airPortRepository) {
    this.airPortRepository = airPortRepository;
  }


  @Override
  @Transactional
  public Airport create(AirportCreationRequest airportCreationRequest) {
    AirportEntity airportEntity = AirportEntityMapper.INSTANCE.toAirportEntity(airportCreationRequest);
    airportEntity.setActive(true);
    AirportEntity savedEntity = airPortRepository.save(airportEntity);
    return AirportEntityMapper.INSTANCE.toAirportResponse(savedEntity);
  }

  @Override
  @Transactional(readOnly = true)
  public List<Airport> fetch(String searchKeyWord) {
    List<AirportEntity> airports = airPortRepository.findAllByAirportNameLike("%" + searchKeyWord.toUpperCase() + "%");
    if (CollectionUtils.isEmpty(airports)) {
      return new ArrayList<>();
    }
    return AirportEntityMapper.INSTANCE.toAirportResponse(airports);
  }

  @Override
  public boolean isAirportExist(final String airportShortCode) {
    AirportEntity airportEntity = airPortRepository.findByAirportShortCodeAndActive(airportShortCode, true);
    return airportEntity != null ? true : false;
  }


}
