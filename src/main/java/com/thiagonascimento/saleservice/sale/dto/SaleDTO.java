package com.thiagonascimento.saleservice.sale.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SaleDTO {
    private String id;
    @NotEmpty(message = "At least one item must be informed")
    private List<ItemDTO> items;
    @NotEmpty(message = "The salesman's name must be informed")
    private String salesmanName;
    private Double totalValue;
    private LocalDate creationDate;
}
