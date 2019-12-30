package com.thiagonascimento.saleservice.analyze.service;

import com.thiagonascimento.saleservice.analyze.domain.Analyze;
import com.thiagonascimento.saleservice.customer.service.CustomerService;
import com.thiagonascimento.saleservice.exception.ErrorInfo;
import com.thiagonascimento.saleservice.exception.GenericException;
import com.thiagonascimento.saleservice.sale.domain.Sale;
import com.thiagonascimento.saleservice.sale.service.SaleService;
import com.thiagonascimento.saleservice.salesman.service.SalesmanService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple4;

import java.util.Comparator;
import java.util.List;

@Service
@AllArgsConstructor
public class AnalyzeService {

    private CustomerService customerService;
    private SalesmanService salesmanService;
    private SaleService saleService;

    public Mono<Analyze> analyze() {
        var allSales = findAllSales();
        return Mono.zip(getCustomerQuantity(), getSalesmanQuantity(),
                getMostExpensiveSaleId(allSales), getWorstSalesman(allSales))
                .map((Tuple4<Long, Long, String, String> objects) -> {
                    var analyze = Analyze.builder().build();
                    setResults(objects.getT1(), objects.getT2(), objects.getT3(), objects.getT4(), analyze);
                    return analyze;
                });
    }

    private Flux<Sale> findAllSales() {
        return saleService.findAll().switchIfEmpty(Mono.error(
                new GenericException(getNoDataToAnalyzeError(), HttpStatus.BAD_REQUEST)));
    }

    private Mono<Long> getCustomerQuantity() {
        return customerService.findAll().switchIfEmpty(Mono.error(
                new GenericException(getNoDataToAnalyzeError(), HttpStatus.BAD_REQUEST))).count();
    }

    private Mono<Long> getSalesmanQuantity() {
        return salesmanService.findAll().switchIfEmpty(Mono.error(
                new GenericException(getNoDataToAnalyzeError(), HttpStatus.BAD_REQUEST))).count();
    }

    private ErrorInfo getNoDataToAnalyzeError() {
        return ErrorInfo.builder()
                .message("There's no data to analyze." +
                        " Initialize the database using the endpoint: " +
                        "'http://localhost:8080/sales/v1/initialize' and try again.")
                .build();
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
                            String worstSalesman, Analyze analyze) {
        analyze.setCustomerQuantity(customerQuantity);
        analyze.setSalesmanQuantity(salesmanQuantity);
        analyze.setMostExpensiveSaleId(mostExpensiveSaleId);
        analyze.setWorstSalesman(worstSalesman);
    }
}
