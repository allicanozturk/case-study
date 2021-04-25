package com.example.casestudy.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateUtil {

  public static final String BASIC_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";

  private DateUtil() {
  }

  public static Date convertToDate(String date, String dateFormat) {
    SimpleDateFormat dateFormatter = new SimpleDateFormat(dateFormat);
    try {
      Date convertedDate = dateFormatter.parse(date);
      return convertedDate;
    } catch (ParseException e) {
      return null;
    }
  }


}
