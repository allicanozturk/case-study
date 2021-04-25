package com.example.casestudy.service;

import com.example.casestudy.dto.model.OperationResult;
import com.example.casestudy.dto.request.PaymentRequest;

public interface IPaymentService {

  OperationResult payment(PaymentRequest request);
}
