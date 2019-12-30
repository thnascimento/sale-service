package com.thiagonascimento.saleservice.stub;

import com.thiagonascimento.saleservice.salesman.domain.Salesman;

public class SalesmanStub {

    public static Salesman salesman() {
        return Salesman.builder()
                .name("Pedro")
                .cpf("1234567891234")
                .salary(50000.0)
                .build();
    }
}
