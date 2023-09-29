package com.boutej.banking.handlers;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.Set;

/**
 * @author Sara Boutej
 * @since 26.09.2023
 */
@Builder
@AllArgsConstructor
@JsonInclude(Include.NON_EMPTY)
public class ExceptionData {

  private String      errorMessage;

  private String      errorSource;

  private Set<String> validationErrors;
}
