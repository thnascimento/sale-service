package com.thiagonascimento.saleservice.stub;

import com.thiagonascimento.saleservice.customer.domain.Customer;

public class CustomerStub {

    public static Customer customer() {
        return Customer.builder()
                .name("José da Silva")
                .cnpj("2345675434544345")
                .businessArea("Rural")
                .build();
    }
}
