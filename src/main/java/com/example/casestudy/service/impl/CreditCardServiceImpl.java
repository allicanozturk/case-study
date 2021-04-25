package com.example.casestudy.service.impl;

import com.example.casestudy.service.ICreditCardService;
import org.springframework.stereotype.Service;

@Service
public class CreditCardServiceImpl implements ICreditCardService {

  @Override
  public String maskCardNumber(String cardNumber) {
    String[] characteristics = cardNumber.split("");
    StringBuilder stringBuilder = new StringBuilder();

    for (int i = 0; i < characteristics.length; i++) {
      if (i < 4 || (i >= 15 && i <= 18)) {
        stringBuilder.append(characteristics[i]);
      } else if (i == 4 || i == 9 || i == 14) {
        continue;
      } else {
        stringBuilder.append("*");
      }
    }
    return stringBuilder.toString();
  }
}
