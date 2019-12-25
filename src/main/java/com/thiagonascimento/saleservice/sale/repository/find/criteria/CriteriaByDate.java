package com.thiagonascimento.saleservice.sale.repository.find.criteria;

import com.thiagonascimento.saleservice.sale.domain.FindSaleParameters;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CriteriaByDate implements CriteriaGenerator {

    @Override
    public Boolean parameterIsPresent(FindSaleParameters parameters) {
        return Objects.nonNull(parameters.getInitialDate()) && Objects.nonNull(parameters.getFinalDate());
    }

    @Override
    public void addCriteria(FindSaleParameters parameters, Criteria criteria) {
        criteria.and("creationDate")
                .gte(parameters.getInitialDate())
                .lte(parameters.getFinalDate());
    }
}
