package com.example.casestudy.validation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestValidation {

  String validatorPath() default "";

}
