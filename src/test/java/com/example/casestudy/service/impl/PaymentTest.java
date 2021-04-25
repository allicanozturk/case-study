package com.example.casestudy.service.impl;

import com.example.casestudy.dto.event.AfterPaymentEvent;
import com.example.casestudy.dto.model.OperationResult;
import com.example.casestudy.dto.request.PaymentRequest;
import com.example.casestudy.entity.PaymentEntity;
import com.example.casestudy.repository.PaymentRepository;
import com.example.casestudy.service.ICreditCardService;
import com.example.casestudy.util.EventPublisher;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.mockito.verification.After;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class PaymentTest {

  @Mock
  private PaymentRepository paymentRepository;
  @Mock
  private EventPublisher eventPublisher;
  @Mock
  private ICreditCardService creditCardService;
  @InjectMocks
  private PaymentServiceImpl paymentService;

  @Test
  void whenPaymentSuccess_thenReturnOperationResult(){
    PaymentRequest request = new PaymentRequest();
    request.setTicketId(1L);
    request.setCardNumber("1234-1234-1234-1234");

    when(creditCardService.maskCardNumber(request.getCardNumber())).thenReturn("1234********1234");
    doNothing().when(eventPublisher).publishEvent(any(AfterPaymentEvent.class));
    when(paymentRepository.save(any(PaymentEntity.class))).thenReturn(any(PaymentEntity.class));

    OperationResult result = paymentService.payment(request);
    assertNotNull(result);
    assertTrue(result instanceof OperationResult);
  }

}
