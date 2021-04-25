package com.example.casestudy.validation.validator.impl;

import com.example.casestudy.dto.request.BaseRequest;
import com.example.casestudy.dto.request.PaymentRequest;
import com.example.casestudy.entity.TicketEntity;
import com.example.casestudy.repository.TicketRepository;
import com.example.casestudy.util.GeneralEnumerationDefinition;
import com.example.casestudy.validation.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PaymentValidator implements Validator {

  @Autowired
  private TicketRepository ticketRepository;

  @Override
  public boolean validate(BaseRequest input) {

    if (input instanceof PaymentRequest) {
      final PaymentRequest request = (PaymentRequest) input;
      Optional<TicketEntity> ticketEntity = ticketRepository.findById(request.getTicketId());
      return ticketEntity.isPresent() == false || !GeneralEnumerationDefinition.TicketStatus.PENDING.name().equals(ticketEntity.get().getStatus())
         ? false : true;
    }
    return false;
  }
}
