package com.example.casestudy.validation.validator.impl;

import com.example.casestudy.dto.request.AirportCreationRequest;
import com.example.casestudy.dto.request.BaseRequest;
import com.example.casestudy.service.IAirportService;
import com.example.casestudy.validation.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AirportValidator implements Validator {

  private final IAirportService airportService;

  @Autowired
  public AirportValidator(IAirportService airportService) {
    this.airportService = airportService;
  }

  @Override
  public boolean validate(BaseRequest input) {

    if(input instanceof AirportCreationRequest){
      final AirportCreationRequest request = (AirportCreationRequest) input;
      boolean airportExist = airportService.isAirportExist(request.getAirportShortCode());
      return  airportExist == true? false:true;
    }
    return false;
  }

}
