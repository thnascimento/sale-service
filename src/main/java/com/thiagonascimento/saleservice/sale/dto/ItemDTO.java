package com.thiagonascimento.saleservice.sale.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ItemDTO {
    private String id;
    @NotNull(message = "Quantity must be informed")
    private Integer quantity;
    @NotNull(message = "Price must be informed")
    private Double price;
}
