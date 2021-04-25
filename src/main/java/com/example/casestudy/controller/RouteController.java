package com.example.casestudy.controller;

import com.example.casestudy.dto.request.RouteCreationRequest;
import com.example.casestudy.dto.response.GenericResponse;
import com.example.casestudy.dto.model.Route;
import com.example.casestudy.service.IRouteService;
import com.example.casestudy.util.RequestPath;
import com.example.casestudy.validation.RequestValidation;
import com.example.casestudy.validation.validator.ValidatorPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = RequestPath.ROUTE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class RouteController {

  private final IRouteService routeService;

  @Autowired
  public RouteController(IRouteService routeService) {
    this.routeService = routeService;
  }

  @PostMapping()
  @RequestValidation(validatorPath = ValidatorPath.ROUTE_VALIDATOR)
  public ResponseEntity<GenericResponse<Route>> createRoute(@Validated @RequestBody RouteCreationRequest request){
    GenericResponse response = GenericResponse.createSuccessfulResponse(routeService.create(request));
    return new ResponseEntity<>(response, HttpStatus.CREATED);
  }
}
