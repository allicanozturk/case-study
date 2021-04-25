package com.example.casestudy.validation;

import com.example.casestudy.dto.request.BaseRequest;
import com.example.casestudy.util.AspectUtil;
import com.example.casestudy.validation.validator.Validator;
import org.aspectj.lang.ProceedingJoinPoint;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Aspect
@Order(1)
@Component
public class RequestValidationComponent {

  private final ValidationManager validationManager;

  @Autowired
  public RequestValidationComponent(ValidationManager validationManager) {
    this.validationManager = validationManager;
  }

  @Around("@annotation(requestValidation)")
  public Object validateResource(ProceedingJoinPoint joinPoint, RequestValidation requestValidation) throws Throwable {
    boolean validationResult;

    Validator validator = validationManager.getValidator(requestValidation.validatorPath());
    final Object validationInput = AspectUtil.obtainAspectInput(joinPoint);

    if (validationInput instanceof BaseRequest) {
      validationResult = validator.validate((BaseRequest) validationInput);
    } else {
      String input = validationInput != null ? validationInput.toString() : null;
      validationResult = validator.validate(input);
    }
    return validationResult == true ? joinPoint.proceed() : new ResponseEntity(HttpStatus.BAD_REQUEST);
  }


}
