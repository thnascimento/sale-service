package com.thiagonascimento.saleservice.customer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CustomerDTO {
    @NotNull(message = "CNPJ must be informed")
    private String cnpj;
    @NotNull(message = "Name must be informed")
    private String name;
    private String businessArea;
}
