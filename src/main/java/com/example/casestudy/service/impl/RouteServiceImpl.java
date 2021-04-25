package com.example.casestudy.service.impl;

import com.example.casestudy.dto.request.RouteCreationRequest;
import com.example.casestudy.dto.model.Route;

import com.example.casestudy.entity.AirportEntity;
import com.example.casestudy.entity.RouteEntity;
import com.example.casestudy.mapper.RouteEntityMapper;
import com.example.casestudy.repository.AirPortRepository;
import com.example.casestudy.repository.RouteRepository;
import com.example.casestudy.service.IRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RouteServiceImpl implements IRouteService {

  @Autowired
  private RouteRepository routeRepository;

  @Autowired
  private AirPortRepository airPortRepository;

  @Override
  @Transactional
  public Route create(RouteCreationRequest request) {
    RouteEntity routeEntity = RouteEntityMapper.INSTANCE.toRouteEntity(request);
    routeEntity.setActive(true);

    List<AirportEntity> airports = airPortRepository.findAllByAirportIdIn(Arrays.asList(request.getArrivalAirportId(), request.getDepartureAirportId()));
    Map<Long, AirportEntity> airportMap = airports.stream()
        .collect(Collectors.toMap(AirportEntity::getAirportId, airport -> airport));

    routeEntity.setFrom(airportMap.get(request.getDepartureAirportId()));
    routeEntity.setTo(airportMap.get(request.getArrivalAirportId()));
    RouteEntity createdEntity = routeRepository.save(routeEntity);

    return RouteEntityMapper.INSTANCE.toRouteCreationResponse(createdEntity);
  }

  @Override
  public boolean isRouteExist(Long from, Long to) {
    RouteEntity routeEntity = routeRepository.findByFromAirportIdAndToAirportIdAndActive(from, to, true);
    return routeEntity != null ? true : false;
  }

}

