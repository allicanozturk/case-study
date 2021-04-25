package com.example.casestudy.service.impl;

import com.example.casestudy.dto.request.FlightCreationRequest;
import com.example.casestudy.dto.model.Flight;
import com.example.casestudy.entity.AirlineEntity;
import com.example.casestudy.entity.FlightEntity;
import com.example.casestudy.entity.RouteEntity;
import com.example.casestudy.mapper.FlightEntityMapper;
import com.example.casestudy.repository.AirlineRepository;
import com.example.casestudy.repository.FlightRepository;
import com.example.casestudy.repository.RouteRepository;
import com.example.casestudy.service.IFlightService;
import com.example.casestudy.util.DateUtil;
import com.example.casestudy.util.GeneralEnumerationDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class FlightServiceImpl implements IFlightService {

  @Autowired
  private AirlineRepository airlineRepository;
  @Autowired
  private RouteRepository routeRepository;
  @Autowired
  private FlightRepository flightRepository;

  @Override
  @Transactional
  public Flight create(FlightCreationRequest request) {
    FlightEntity flightEntity = FlightEntityMapper.INSTANCE.toFlightEntity(request);
    Optional<AirlineEntity> airlineEntity = airlineRepository.findById(request.getAirlineId());
    Optional<RouteEntity> routeEntity = routeRepository.findById(request.getRouteId());
    flightEntity.setAirline(airlineEntity.get());
    flightEntity.setRoute(routeEntity.get());
    flightEntity.setStatus(GeneralEnumerationDefinition.FlightStatus.ACTIVE.name());
    FlightEntity savedEntity = flightRepository.save(flightEntity);
    return FlightEntityMapper.INSTANCE.toFlightCreationResponse(savedEntity);
  }

  @Override
  @Transactional(readOnly = true)
  public List<Flight> fetch(String from, String to, String departureDate) {
    Date convertedDate = DateUtil.convertToDate(departureDate, DateUtil.BASIC_FORMAT);
    List<FlightEntity> flightEntities = flightRepository.findFlightsByDateAndFromAndTo(convertedDate, from, to);
    if (CollectionUtils.isEmpty(flightEntities)) {
      return new ArrayList<>();
    }
    return FlightEntityMapper.INSTANCE.toFlightCreationResponse(flightEntities);
  }

}
