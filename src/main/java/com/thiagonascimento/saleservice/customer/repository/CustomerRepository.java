package com.thiagonascimento.saleservice.customer.repository;

import com.thiagonascimento.saleservice.customer.domain.Customer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CustomerRepository extends ReactiveMongoRepository<Customer, String> {
}
