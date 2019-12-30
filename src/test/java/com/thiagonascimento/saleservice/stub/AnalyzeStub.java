package com.thiagonascimento.saleservice.stub;

import com.thiagonascimento.saleservice.analyze.domain.Analyze;

public class AnalyzeStub {

    public static Analyze analyze() {
        return Analyze.builder()
                .customerQuantity(1L)
                .salesmanQuantity(1L)
                .mostExpensiveSaleId("mostExpensiveId")
                .worstSalesman("Paulo")
                .build();
    }
}
