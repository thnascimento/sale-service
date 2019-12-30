package com.thiagonascimento.saleservice.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@Data
public class GenericException extends RuntimeException {
    private ErrorInfo errorInfo;
    private HttpStatus status;
}
