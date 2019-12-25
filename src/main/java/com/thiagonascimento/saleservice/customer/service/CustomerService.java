package com.thiagonascimento.saleservice.customer.service;

import com.thiagonascimento.saleservice.customer.domain.Customer;
import com.thiagonascimento.saleservice.customer.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class CustomerService {

    private CustomerRepository repository;

    public Mono<String> create(Customer customer) {
        return repository.insert(customer).map(Customer::getId);
    }

    public Flux<Customer> findAll() {
        return repository.findAll();
    }
}
