package com.thiagonascimento.saleservice.sale.factory;

import com.thiagonascimento.saleservice.sale.domain.FindSaleParameters;

import java.time.LocalDate;

public class FindSaleParametersFactory {

    public static FindSaleParameters findSaleParameters(String id, LocalDate initialDate, LocalDate finalDate) {
        return FindSaleParameters.builder()
                .id(id)
                .initialDate(initialDate)
                .finalDate(finalDate)
                .build();
    }
}
