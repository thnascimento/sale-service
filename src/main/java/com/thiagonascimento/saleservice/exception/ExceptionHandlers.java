package com.thiagonascimento.saleservice.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import reactor.core.publisher.Mono;

@Slf4j
@Configuration
@RestControllerAdvice
@ConditionalOnWebApplication(
        type = ConditionalOnWebApplication.Type.REACTIVE
)
public class ExceptionHandlers {

    @ExceptionHandler({GenericException.class})
    public Mono<ErrorInfo> genericExceptionHandler(GenericException error, ServerHttpResponse response,
                                                   ServerHttpRequest request) {
        log.error("ExceptionHandlers.genericExceptionHandler={}", error);
        response.setStatusCode(error.getStatus());
        error.getErrorInfo().setNamespace(request.getPath().value());
        return Mono.just(error.getErrorInfo());
    }
}
