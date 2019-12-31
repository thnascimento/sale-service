package com.thiagonascimento.saleservice.salesman;

import com.thiagonascimento.saleservice.salesman.dto.SalesmanDTO;
import com.thiagonascimento.saleservice.salesman.mapper.SalesmanMapper;
import com.thiagonascimento.saleservice.salesman.service.SalesmanService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/sales/v1/salesmen")
public class SalesmanController {

    private SalesmanService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<String> create(@Valid @RequestBody SalesmanDTO salesmanDTO) {
        return service.create(SalesmanMapper.mapToModel(salesmanDTO));
    }

    @GetMapping
    public Flux<SalesmanDTO> findAll() {
        return service.findAll().map(SalesmanMapper::mapToDTO);
    }
}
