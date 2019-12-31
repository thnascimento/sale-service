package com.thiagonascimento.saleservice.customer;

import com.thiagonascimento.saleservice.customer.dto.CustomerDTO;
import com.thiagonascimento.saleservice.customer.mapper.CustomerMapper;
import com.thiagonascimento.saleservice.customer.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/sales/v1/customers")
public class CustomerController {

    private CustomerService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<String> create(@Valid @RequestBody CustomerDTO customer) {
        return service.create(CustomerMapper.mapToModel(customer));
    }

    @GetMapping
    public Flux<CustomerDTO> findAll() {
        return service.findAll().map(CustomerMapper::mapToDTO);
    }
}
