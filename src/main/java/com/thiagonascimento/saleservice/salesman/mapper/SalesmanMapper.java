package com.thiagonascimento.saleservice.salesman.mapper;

import com.thiagonascimento.saleservice.salesman.domain.Salesman;
import com.thiagonascimento.saleservice.salesman.dto.SalesmanDTO;

public class SalesmanMapper {

    public static Salesman mapToModel(SalesmanDTO salesmanDTO) {
        return Salesman.builder()
                .name(salesmanDTO.getName())
                .cpf(salesmanDTO.getCpf())
                .salary(salesmanDTO.getSalary())
                .build();
    }

    public static SalesmanDTO mapToDTO(Salesman salesman) {
        return SalesmanDTO.builder()
                .id(salesman.getId())
                .name(salesman.getName())
                .cpf(salesman.getCpf())
                .salary(salesman.getSalary())
                .build();
    }
}
