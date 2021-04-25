package com.example.casestudy.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class MaskCreditCardNumberTest {

  @InjectMocks
  CreditCardServiceImpl creditCardService;

  private final String creditCardNumber = "1234-5678-8765-4321";

  @Test
  void whenCreditNumberUnMask_theReturnMaskedCardNumber(){
    String result = creditCardService.maskCardNumber(creditCardNumber);
    String firstFourCharacter = result.substring(0, 4);
    String lastFourCharacter = result.substring(12,16);
    String maskedPart = result.substring(4,12);

    assertEquals("1234",firstFourCharacter);
    assertEquals("4321",lastFourCharacter);
    assertEquals("********",maskedPart);
  }

}
