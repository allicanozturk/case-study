package com.example.casestudy.service;

import com.example.casestudy.dto.request.RouteCreationRequest;
import com.example.casestudy.dto.model.Route;

public interface IRouteService {

  Route create(RouteCreationRequest request);

  boolean isRouteExist(Long from, Long to);
}
