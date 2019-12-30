package com.thiagonascimento.saleservice.analyze.service;

import com.thiagonascimento.saleservice.customer.service.CustomerService;
import com.thiagonascimento.saleservice.sale.service.SaleService;
import com.thiagonascimento.saleservice.salesman.service.SalesmanService;
import com.thiagonascimento.saleservice.stub.AnalyzeStub;
import com.thiagonascimento.saleservice.stub.CustomerStub;
import com.thiagonascimento.saleservice.stub.SaleStub;
import com.thiagonascimento.saleservice.stub.SalesmanStub;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AnalyzeServiceTest {

    @Mock
    private CustomerService customerService;
    @Mock
    private SalesmanService salesmanService;
    @Mock
    private SaleService saleService;
    @InjectMocks
    private AnalyzeService analyzeService;

    @Test
    void analyze_ShouldAnalyzeCorrectly() {
        when(customerService.findAll()).thenReturn(Flux.just(CustomerStub.customer()));
        when(salesmanService.findAll()).thenReturn(Flux.just(SalesmanStub.salesman()));
        when(saleService.findAll()).thenReturn(Flux.just(SaleStub.mostExpensiveSale(),
                SaleStub.notMostExpensiveSale()));

        var analyse = analyzeService.analyze();

        Assertions.assertEquals(analyse.block(), AnalyzeStub.analyze());

        verify(customerService, times(1)).findAll();
        verify(salesmanService, times(1)).findAll();
        verify(saleService, times(1)).findAll();
    }
}
