package com.thiagonascimento.saleservice.sale.repository.find;

import com.thiagonascimento.saleservice.sale.domain.FindSaleParameters;
import com.thiagonascimento.saleservice.sale.domain.Sale;
import reactor.core.publisher.Flux;

public interface SaleFindRepository {

    Flux<Sale> find(FindSaleParameters parameters);
}
