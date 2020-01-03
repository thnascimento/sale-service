package com.thiagonascimento.saleservice.sale.repository.find.criteria;

import com.thiagonascimento.saleservice.sale.domain.FindSaleParameters;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

@Component
public class CriteriaById implements CriteriaGenerator {

    @Override
    public Boolean parameterIsPresent(FindSaleParameters parameters) {
        return !ObjectUtils.isEmpty(parameters.getId());
    }

    @Override
    public void addCriteria(FindSaleParameters parameters, Criteria criteria) {
        criteria.and("id").is(parameters.getId());
    }
}
