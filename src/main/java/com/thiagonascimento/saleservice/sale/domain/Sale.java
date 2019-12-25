package com.thiagonascimento.saleservice.sale.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Document(collection = "sale")
public class Sale {
    @Id
    private String id;
    private List<Item> items;
    private String salesmanName;
    private LocalDate creationDate;
    private Double totalValue;
}
