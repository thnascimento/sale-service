package com.thiagonascimento.saleservice.sale.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Item {
    private String id;
    private Integer quantity;
    private Double price;
}
