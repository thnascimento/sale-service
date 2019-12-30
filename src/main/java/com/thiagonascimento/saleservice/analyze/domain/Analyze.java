package com.thiagonascimento.saleservice.analyze.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Analyze {
    private Long customerQuantity;
    private Long salesmanQuantity;
    private String mostExpensiveSaleId;
    private String worstSalesman;
}
