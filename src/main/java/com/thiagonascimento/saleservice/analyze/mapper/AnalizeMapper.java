package com.thiagonascimento.saleservice.analyze.mapper;

import com.thiagonascimento.saleservice.analyze.domain.Analyze;
import com.thiagonascimento.saleservice.analyze.dto.AnalizeDTO;

public class AnalizeMapper {

    public static AnalizeDTO mapToDTO(Analyze analyze) {
        return AnalizeDTO.builder()
                .customerQuantity(analyze.getCustomerQuantity())
                .salesmanQuantity(analyze.getSalesmanQuantity())
                .mostExpensiveSaleId(analyze.getMostExpensiveSaleId())
                .worstSalesman(analyze.getWorstSalesman())
                .build();
    }
}
