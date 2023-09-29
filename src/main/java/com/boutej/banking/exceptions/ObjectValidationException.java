package com.boutej.banking.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@RequiredArgsConstructor
public class ObjectValidationException extends RuntimeException {

  @Getter
  private final Set<String> violationsMessage;

  @Getter
  private final String      violationSource;
}
