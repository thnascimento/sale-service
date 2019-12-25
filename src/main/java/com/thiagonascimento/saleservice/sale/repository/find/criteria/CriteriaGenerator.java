package com.thiagonascimento.saleservice.sale.repository.find.criteria;

import com.thiagonascimento.saleservice.sale.domain.FindSaleParameters;
import org.springframework.data.mongodb.core.query.Criteria;

public interface CriteriaGenerator {

    Boolean parameterIsPresent(FindSaleParameters parameters);

    void addCriteria(FindSaleParameters parameters, Criteria criteria);
}
