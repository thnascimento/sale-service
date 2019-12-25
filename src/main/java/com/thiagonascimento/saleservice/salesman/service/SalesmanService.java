package com.thiagonascimento.saleservice.salesman.service;

import com.thiagonascimento.saleservice.salesman.domain.Salesman;
import com.thiagonascimento.saleservice.salesman.repository.SalesmanRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class SalesmanService {

    private SalesmanRepository repository;

    public Mono<String> create(Salesman salesman) {
        return repository.insert(salesman).map(Salesman::getId);
    }

    public Flux<Salesman> findAll() {
        return repository.findAll();
    }
}
