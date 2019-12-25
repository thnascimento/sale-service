package com.thiagonascimento.saleservice.customer.mapper;

import com.thiagonascimento.saleservice.customer.domain.Customer;
import com.thiagonascimento.saleservice.customer.dto.CustomerDTO;

public class CustomerMapper {

    public static Customer mapToModel(CustomerDTO customerDTO) {
        return Customer.builder()
                .name(customerDTO.getName())
                .cnpj(customerDTO.getCnpj())
                .businessArea(customerDTO.getBusinessArea())
                .build();
    }

    public static CustomerDTO mapToDTO(Customer customer) {
        return CustomerDTO.builder()
                .name(customer.getName())
                .cnpj(customer.getCnpj())
                .businessArea(customer.getBusinessArea())
                .build();
    }
}
