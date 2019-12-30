package com.thiagonascimento.saleservice.sale.service;

import com.thiagonascimento.saleservice.sale.domain.FindSaleParameters;
import com.thiagonascimento.saleservice.sale.domain.Item;
import com.thiagonascimento.saleservice.sale.domain.Sale;
import com.thiagonascimento.saleservice.sale.repository.SaleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class SaleService {

    private SaleRepository repository;

    public Mono<String> sale(Sale sale) {
        calculateTotalValue(sale);
        sale.setCreationDate(LocalDate.now());
        return repository.insert(sale).map(Sale::getId);
    }

    private void calculateTotalValue(Sale sale) {
        Double totalValue = sale.getItems().stream()
                .map((Item item) -> item.getPrice() * item.getQuantity())
                .reduce(0D, Double::sum);
        sale.setTotalValue(totalValue);
    }

    public Flux<Sale> find(FindSaleParameters parameters) {
        return repository.find(parameters);
    }

    public Flux<Sale> findAll() {
        return repository.findAll();
    }
}
