package com.example.casestudy.service.impl;

import com.example.casestudy.dto.event.AfterPaymentEvent;
import com.example.casestudy.dto.model.OperationResult;
import com.example.casestudy.dto.request.PaymentRequest;
import com.example.casestudy.entity.PaymentEntity;
import com.example.casestudy.repository.PaymentRepository;
import com.example.casestudy.service.ICreditCardService;
import com.example.casestudy.service.IPaymentService;
import com.example.casestudy.util.EventPublisher;
import com.example.casestudy.util.GeneralEnumerationDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class PaymentServiceImpl implements IPaymentService {

  private final PaymentRepository paymentRepository;
  private final EventPublisher eventPublisher;
  private final ICreditCardService creditCardService;

  @Autowired
  public PaymentServiceImpl(PaymentRepository paymentRepository, EventPublisher eventPublisher, ICreditCardService creditCardService) {
    this.paymentRepository = paymentRepository;
    this.eventPublisher = eventPublisher;
    this.creditCardService = creditCardService;
  }


  @Override
  @Transactional
  public OperationResult payment(PaymentRequest request) {
    String maskedCardNumber = creditCardService.maskCardNumber(request.getCardNumber());
    PaymentEntity paymentEntity = new PaymentEntity();
    paymentEntity.setCardNumber(maskedCardNumber);
    paymentEntity.setTicketId(request.getTicketId());
    paymentEntity.setTransactionNumber(String.valueOf(System.currentTimeMillis()));
    paymentRepository.save(paymentEntity);
    AfterPaymentEvent event = new AfterPaymentEvent(this,request.getTicketId());
    eventPublisher.publishEvent(event);
    return  OperationResult.newInstance(GeneralEnumerationDefinition.OperationResultCode.SUCCESSFUL);
  }

}
