package com.thiagonascimento.saleservice.customer.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Document(collection = "customer")
public class Customer {
    @Id
    private String id;
    private String cnpj;
    private String name;
    private String businessArea;
}
