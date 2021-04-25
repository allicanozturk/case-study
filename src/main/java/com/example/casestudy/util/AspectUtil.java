package com.example.casestudy.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.web.bind.annotation.RequestBody;


import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public final class AspectUtil {

  private AspectUtil() {
  }

  public static Object obtainAspectInput(ProceedingJoinPoint joinPoint) {
    Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
    for (int i = 0; i < method.getParameters().length; i++) {
      Parameter parameter = method.getParameters()[i];
      RequestBody annotation = parameter.getAnnotation(RequestBody.class);
      if (annotation != null) {
        return joinPoint.getArgs()[i];
      }
    }
    return null;
  }

}
