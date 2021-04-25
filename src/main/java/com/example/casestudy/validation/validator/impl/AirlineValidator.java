package com.example.casestudy.validation.validator.impl;

import com.example.casestudy.dto.request.AirlineCreationRequest;
import com.example.casestudy.dto.request.BaseRequest;
import com.example.casestudy.service.IAirlineService;
import com.example.casestudy.validation.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AirlineValidator implements Validator {

  private final IAirlineService airlineService;

  @Autowired
  public AirlineValidator(IAirlineService airlineService) {
    this.airlineService = airlineService;
  }

  @Override
  public boolean validate(BaseRequest input) {
    if (input instanceof AirlineCreationRequest) {
      final AirlineCreationRequest request = (AirlineCreationRequest) input;
      boolean airlineExist = airlineService.isAirlineExist(request.getCompanyShortCode());
      return airlineExist == true ? false : true;
    }
    return false;
  }

}
