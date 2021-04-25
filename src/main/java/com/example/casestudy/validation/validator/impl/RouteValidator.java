package com.example.casestudy.validation.validator.impl;

import com.example.casestudy.dto.request.BaseRequest;
import com.example.casestudy.dto.request.RouteCreationRequest;
import com.example.casestudy.service.IRouteService;
import com.example.casestudy.validation.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RouteValidator implements Validator {

  private final IRouteService routeService;

  @Autowired
  public RouteValidator(IRouteService routeService) {
    this.routeService = routeService;
  }

  @Override
  public boolean validate(BaseRequest input) {

    if (input instanceof RouteCreationRequest) {
      final RouteCreationRequest request = (RouteCreationRequest) input;

      if (request.getDepartureAirportId().equals(request.getArrivalAirportId())) {
        return false;
      }

      boolean routeExist = routeService.isRouteExist(request.getDepartureAirportId(), request.getArrivalAirportId());
      return routeExist == true ? false : true;
    }
    return false;
  }

}
