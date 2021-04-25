package com.example.casestudy.validation.validator.impl;

import com.example.casestudy.dto.request.BaseRequest;
import com.example.casestudy.dto.request.TicketCreationRequest;
import com.example.casestudy.entity.FlightEntity;
import com.example.casestudy.repository.FlightRepository;
import com.example.casestudy.util.GeneralEnumerationDefinition;
import com.example.casestudy.validation.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class TicketValidator implements Validator {

  private final FlightRepository flightRepository;

  @Autowired
  public TicketValidator(FlightRepository flightRepository) {
    this.flightRepository = flightRepository;
  }

  @Override
  public boolean validate(BaseRequest input) {

    if (input instanceof TicketCreationRequest) {
      final TicketCreationRequest request = (TicketCreationRequest) input;
      FlightEntity flightEntity = flightRepository.findByFlightId(request.getFlightId());
      return (flightEntity == null || !GeneralEnumerationDefinition.FlightStatus.ACTIVE.name().equals(flightEntity.getStatus())
          || flightEntity.getAvailableSeat() == 0) ? false : true;
    }
    return false;
  }

}
