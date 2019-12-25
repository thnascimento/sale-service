package com.thiagonascimento.saleservice.sale.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FindSaleParameters {
    private String id;
    private LocalDate initialDate;
    private LocalDate finalDate;
}
