package com.example.casestudy.controller;

import com.example.casestudy.dto.request.PaymentRequest;
import com.example.casestudy.service.IPaymentService;
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
@RequestMapping(value = RequestPath.PAYMENT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class PaymentController {

  private final IPaymentService paymentService;

  @Autowired
  public PaymentController(IPaymentService paymentService) {
    this.paymentService = paymentService;
  }

  @PostMapping()
  @RequestValidation(validatorPath = ValidatorPath.PAYMENT_VALIDATOR)
  public ResponseEntity<?> payment(@Validated @RequestBody PaymentRequest request) {
    return new ResponseEntity<>(paymentService.payment(request),HttpStatus.OK);
  }

}
