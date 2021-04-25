package com.example.casestudy.validation.validator;

public final class ValidatorPath {

  private static final String BASE_PATH = "com.example.casestudy.validation.validator.impl.";
  public static final String AIRLINE_VALIDATOR = BASE_PATH + "AirlineValidator";
  public static final String AIRPORT_VALIDATOR = BASE_PATH + "AirportValidator";
  public static final String ROUTE_VALIDATOR = BASE_PATH + "RouteValidator";
  public static final String TICKET_VALIDATOR = BASE_PATH + "TicketValidator";
  public static final String PAYMENT_VALIDATOR = BASE_PATH + "PaymentValidator";

  private ValidatorPath() {
  }
}
