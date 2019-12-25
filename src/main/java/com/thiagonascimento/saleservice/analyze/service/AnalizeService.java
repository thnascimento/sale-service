package com.thiagonascimento.saleservice.analyze.service;

import com.thiagonascimento.saleservice.analyze.domain.Analize;
import com.thiagonascimento.saleservice.customer.service.CustomerService;
import com.thiagonascimento.saleservice.sale.domain.Sale;
import com.thiagonascimento.saleservice.sale.service.SaleService;
import com.thiagonascimento.saleservice.salesman.service.SalesmanService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple4;

import java.util.Comparator;
import java.util.List;

@Service
@AllArgsConstructor
public class AnalizeService {

    private CustomerService customerService;
    private SalesmanService salesmanService;
    private SaleService saleService;

    public Mono<Analize> analize() {
        var allSales = findAllSales();
        return Mono.zip(getCustomerQuantity(), getSalesmanQuantity(),
                getMostExpensiveSaleId(allSales), getWorstSalesman(allSales))
                .map((Tuple4<Long, Long, String, String> objects) -> {
                    var analize = Analize.builder().build();
                    setResults(objects.getT1(), objects.getT2(), objects.getT3(), objects.getT4(), analize);
                    return analize;
                });
    }

    private Flux<Sale> findAllSales() {
        return saleService.findAll();
    }

    private Mono<Long> getCustomerQuantity() {
        return customerService.findAll().count();
    }

    private Mono<Long> getSalesmanQuantity() {
        return salesmanService.findAll().count();
    }

    private Mono<String> getMostExpensiveSaleId(Flux<Sale> allSales) {
        return allSales.collectList()
                .map((List<Sale> sales) -> sales.stream()
                        .max(Comparator.comparing(Sale::getTotalValue)).map(Sale::getId).orElse(null));
    }

    private Mono<String> getWorstSalesman(Flux<Sale> allSales) {
        return allSales.collectList()
                .map((List<Sale> sales) -> sales.stream()
                        .min(Comparator.comparing(Sale::getTotalValue)).map(Sale::getSalesmanName)
                        .orElse(null));
    }

    private void setResults(Long customerQuantity, Long salesmanQuantity, String mostExpensiveSaleId,
                            String worstSalesman, Analize analize) {
        analize.setCustomerQuantity(customerQuantity);
        analize.setSalesmanQuantity(salesmanQuantity);
        analize.setMostExpensiveSaleId(mostExpensiveSaleId);
        analize.setWorstSalesman(worstSalesman);
    }
}
