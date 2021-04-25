package com.example.casestudy.validation;

import com.example.casestudy.validation.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class ValidationManagerImpl implements ValidationManager{

  @Autowired
  private ApplicationContext applicationContext;

  @Override
  public Validator getValidator(String validatorPath) throws ClassNotFoundException {
    Class clazz = Class.forName(validatorPath);
    Validator validator = (Validator) applicationContext.getBean(clazz);
    return validator;
  }

}
