package com.thiagonascimento.saleservice.salesman.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SalesmanDTO {
    private String id;
    @NotEmpty(message = "CPF must be informed")
    private String cpf;
    @NotEmpty(message = "Name must be informed")
    private String name;
    @NotNull(message = "Salary must be informed")
    private Double salary;
}
