package com.thiagonascimento.saleservice.initialization;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping("/sales/v1/initialize")
public class InitializationController {

    private InitializationService initializationService;

    @PostMapping
    public Mono<Void> initialize() {
        return initializationService.initialize();
    }
}
