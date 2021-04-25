package com.example.casestudy.exception;

import com.example.casestudy.dto.model.OperationResult;
import com.example.casestudy.util.ErrorMessages;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

  final Logger logger = LogManager.getLogger(this.getClass());

  @ExceptionHandler({ResourceNotFoundException.class})
  public ResponseEntity<?> handleResourceNotFoundException(final Exception ex){
    logger.error("error message: "+ ex.getMessage());
    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler({Exception.class})
  public ResponseEntity<OperationResult> handleAllException(final Exception ex) {
    final String errorId = String.valueOf(System.currentTimeMillis());
    OperationResult errorResult = OperationResult.createErrorResult(errorId, ErrorMessages.UNEXPECTED_ERROR);
    logger.error("error id: "+ errorId + "error message: " + ex.getMessage());
    return ResponseEntity.ok(errorResult);
  }

}
