package com.thiagonascimento.saleservice.analyze.mapper;

import com.thiagonascimento.saleservice.analyze.domain.Analize;
import com.thiagonascimento.saleservice.analyze.dto.AnalizeDTO;

public class AnalizeMapper {

    public static AnalizeDTO mapToDTO(Analize analize) {
        return AnalizeDTO.builder()
                .customerQuantity(analize.getCustomerQuantity())
                .salesmanQuantity(analize.getSalesmanQuantity())
                .mostExpensiveSaleId(analize.getMostExpensiveSaleId())
                .worstSalesman(analize.getWorstSalesman())
                .build();
    }
}
