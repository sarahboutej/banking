package com.boutej.banking.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class OperationNonPermittedException extends RuntimeException {

  private final String errorMessage;

  private final String operationId;

  private final String Source;

  private final String dependency;
}
