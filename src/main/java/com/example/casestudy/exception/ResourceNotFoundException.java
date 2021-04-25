package com.example.casestudy.exception;

public class ResourceNotFoundException extends RuntimeException{

  public ResourceNotFoundException(String message) {
    super(message);
  }
}
