package com.thiagonascimento.saleservice.analyze.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AnalizeDTO {
    private Long customerQuantity;
    private Long salesmanQuantity;
    private String mostExpensiveSaleId;
    private String worstSalesman;
}
