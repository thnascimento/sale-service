package com.thiagonascimento.saleservice.sale;

import com.thiagonascimento.saleservice.sale.dto.SaleDTO;
import com.thiagonascimento.saleservice.sale.factory.FindSaleParametersFactory;
import com.thiagonascimento.saleservice.sale.mapper.SaleMapper;
import com.thiagonascimento.saleservice.sale.service.SaleService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.time.LocalDate;

@RestController
@AllArgsConstructor
@RequestMapping("/sales/v1/sales")
public class SaleController {

    private SaleService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<String> sale(@Valid @RequestBody SaleDTO sale) {
        return service.sale(SaleMapper.mapToModel(sale));
    }

    @GetMapping
    public Flux<SaleDTO> find(@RequestParam(value = "id", required = false) String id,
                              @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                              @RequestParam(value = "initial_date", required = false) LocalDate initialDate,
                              @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                              @RequestParam(value = "final_date", required = false) LocalDate finalDate) {
        return service.find(FindSaleParametersFactory.findSaleParameters(id, initialDate, finalDate))
                .map(SaleMapper::mapToDTO);
    }
}
