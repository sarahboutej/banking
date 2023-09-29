package com.boutej.banking.handlers;

import com.boutej.banking.exceptions.ObjectValidationException;
import com.boutej.banking.exceptions.OperationNonPermittedException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Sara Boutej
 * @since 26.09.2023
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(ObjectValidationException.class)
  public ResponseEntity<ExceptionData> handleException(ObjectValidationException exception) {

    ExceptionData exceptionData = ExceptionData.builder()
                                               .errorMessage("Object not valid exception has occurred")
                                               .errorSource(exception.getViolationSource())
                                               .validationErrors(exception.getViolationsMessage())
                                               .build();
    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                         .body(exceptionData);
  }

  @ExceptionHandler(EntityNotFoundException.class)
  public ResponseEntity<ExceptionData> handleException(EntityNotFoundException exception) {
    ExceptionData exceptionData = ExceptionData.builder()
                                               .errorMessage(exception.getMessage())
                                               .build();
    return ResponseEntity.status(HttpStatus.NOT_FOUND)
                         .body(exceptionData);

  }
  @ExceptionHandler(OperationNonPermittedException.class)
  public ResponseEntity<ExceptionData> handleException(OperationNonPermittedException exception) {
    ExceptionData exceptionData = ExceptionData.builder()
                                               .errorMessage(exception.getMessage())
                                               .build();
    return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                         .body(exceptionData);

  }

}
