package com.example.casestudy.validation.validator;

import com.example.casestudy.dto.request.BaseRequest;

public interface Validator {

  boolean validate(BaseRequest input);

  default boolean validate(String input){
    return true;  // path variable için gerek olursa sonra implementasyonda override et.
  }
}
