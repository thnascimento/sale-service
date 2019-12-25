package com.thiagonascimento.saleservice.sale.repository;

import com.thiagonascimento.saleservice.sale.domain.Sale;
import com.thiagonascimento.saleservice.sale.repository.find.SaleFindRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface SaleRepository extends ReactiveMongoRepository<Sale, String>, SaleFindRepository {
}
