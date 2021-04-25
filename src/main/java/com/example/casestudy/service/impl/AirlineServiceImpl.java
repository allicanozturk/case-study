package com.example.casestudy.service.impl;

import com.example.casestudy.dto.request.AirlineCreationRequest;
import com.example.casestudy.dto.model.Airline;
import com.example.casestudy.entity.AirlineEntity;
import com.example.casestudy.mapper.AirLinetEntityMapper;
import com.example.casestudy.repository.AirlineRepository;
import com.example.casestudy.service.IAirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class AirlineServiceImpl implements IAirlineService {

  private final AirlineRepository airlineRepository;

  @Autowired
  public AirlineServiceImpl(AirlineRepository airlineRepository) {
    this.airlineRepository = airlineRepository;
  }


  @Override
  @Transactional
  public Airline create(AirlineCreationRequest request) {
    AirlineEntity airlineEntity = AirLinetEntityMapper.INSTANCE.toAirLineEntity(request);
    airlineEntity.setActive(true);
    AirlineEntity savedEntity = airlineRepository.save(airlineEntity);
    Airline airline = AirLinetEntityMapper.INSTANCE.toAirLineResponse(savedEntity);
    return airline;
  }

  @Override
  @Transactional(readOnly = true)
  public List<Airline> fetch(String searchKeyWord) {
    List<AirlineEntity> airlineEntities = airlineRepository.findAllByCompanyNameLike("%" + searchKeyWord + "%");
    if (CollectionUtils.isEmpty(airlineEntities)) {
      return new ArrayList<>();
    }
    return AirLinetEntityMapper.INSTANCE.toAirLineResponse(airlineEntities);
  }

  @Override
  public boolean isAirlineExist(final String airlineShortCode) {
    AirlineEntity airlineEntity = airlineRepository.findByCompanyShortCodeAndActive(airlineShortCode, true);
    return airlineEntity != null ? true : false;
  }

}
