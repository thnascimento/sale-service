package com.thiagonascimento.saleservice.sale;

import com.thiagonascimento.saleservice.sale.dto.SaleDTO;
import com.thiagonascimento.saleservice.sale.factory.FindSaleParametersFactory;
import com.thiagonascimento.saleservice.sale.mapper.SaleMapper;
import com.thiagonascimento.saleservice.sale.service.SaleService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@RestController
@AllArgsConstructor
@Validated
@RequestMapping("/sales/v1/sale")
public class SaleController {

    private SaleService service;

    @PostMapping
    public Mono<String> sale(@RequestBody SaleDTO sale) {
        return service.sale(SaleMapper.mapToModel(sale));
    }

    @GetMapping
    public Flux<SaleDTO> find(@RequestParam("id") String id,
                              @RequestParam("initial_date") LocalDate initialDate,
                              @RequestParam("final_date") LocalDate finalDate) {
        return service.find(FindSaleParametersFactory.findSaleParameters(id, initialDate, finalDate))
                .map(SaleMapper::mapToDTO);
    }
}
