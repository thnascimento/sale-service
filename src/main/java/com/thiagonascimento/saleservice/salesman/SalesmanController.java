package com.thiagonascimento.saleservice.salesman;

import com.thiagonascimento.saleservice.salesman.dto.SalesmanDTO;
import com.thiagonascimento.saleservice.salesman.mapper.SalesmanMapper;
import com.thiagonascimento.saleservice.salesman.service.SalesmanService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping("/sales/v1/salesmen")
public class SalesmanController {

    private SalesmanService service;

    @PostMapping
    public Mono<String> create(@RequestBody SalesmanDTO salesmanDTO) {
        return service.create(SalesmanMapper.mapToModel(salesmanDTO));
    }

    @GetMapping
    public Flux<SalesmanDTO> findAll() {
        return service.findAll().map(SalesmanMapper::mapToDTO);
    }
}
