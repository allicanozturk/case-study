package com.example.casestudy.validation;


import com.example.casestudy.validation.validator.Validator;

public interface ValidationManager {

   Validator getValidator(String validatorPath) throws ClassNotFoundException;



}
