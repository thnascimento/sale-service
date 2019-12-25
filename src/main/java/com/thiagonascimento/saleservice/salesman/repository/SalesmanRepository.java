package com.thiagonascimento.saleservice.salesman.repository;

import com.thiagonascimento.saleservice.salesman.domain.Salesman;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface SalesmanRepository extends ReactiveMongoRepository<Salesman, String> {
}
