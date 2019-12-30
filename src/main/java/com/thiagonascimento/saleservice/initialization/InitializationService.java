package com.thiagonascimento.saleservice.initialization;

import com.thiagonascimento.saleservice.customer.domain.Customer;
import com.thiagonascimento.saleservice.customer.repository.CustomerRepository;
import com.thiagonascimento.saleservice.sale.domain.Item;
import com.thiagonascimento.saleservice.sale.domain.Sale;
import com.thiagonascimento.saleservice.sale.service.SaleService;
import com.thiagonascimento.saleservice.salesman.domain.Salesman;
import com.thiagonascimento.saleservice.salesman.repository.SalesmanRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Arrays;

@Service
@AllArgsConstructor
public class InitializationService {

    private SalesmanRepository salesmanRepository;
    private CustomerRepository customerRepository;
    private SaleService saleService;

    public Mono<Void> initialize() {
        return Mono.zip(instantiateSalesmen(), instantiateCustomers(), instantiateSales())
                .then();
    }

    private Mono<Void> instantiateSalesmen() {
        var salesmanPedro = Salesman.builder()
                .name("Pedro")
                .cpf("1234567891234")
                .salary(50000.0)
                .build();
        var salesmanPaulo = Salesman.builder()
                .name("Paulo")
                .cpf("3245678865434")
                .salary(40000.99)
                .build();
        return salesmanRepository.saveAll(Arrays.asList(salesmanPedro, salesmanPaulo)).then();
    }

    private Mono<Void> instantiateCustomers() {
        var customerJose = Customer.builder()
                .name("José da Silva")
                .cnpj("2345675434544345")
                .businessArea("Rural")
                .build();
        var customerEduardo = Customer.builder()
                .name("Eduardo Pereira")
                .cnpj("2345675433444345")
                .businessArea("Rural")
                .build();
        return customerRepository.saveAll(Arrays.asList(customerJose, customerEduardo)).then();
    }

    private Mono<Void> instantiateSales() {

        var salePedro = Sale.builder()
                .items(Arrays.asList(
                        buildItem("1", 10, 100.0),
                        buildItem("2", 30, 2.50),
                        buildItem("3", 40, 100.0)))
                .salesmanName("Pedro")
                .build();
        var salePaulo = Sale.builder()
                .items(Arrays.asList(
                        buildItem("1", 34, 10.0),
                        buildItem("2", 33, 1.50),
                        buildItem("3", 40, 0.10)))
                .salesmanName("Paulo")
                .build();
        return Mono.zip(saleService.sale(salePaulo).then(),
                saleService.sale(salePedro).then()).then();
    }

    private Item buildItem(String id, Integer quantity, Double value) {
        return Item.builder()
                .id(id)
                .quantity(quantity)
                .price(value)
                .build();
    }
}
