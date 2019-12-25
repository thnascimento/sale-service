package com.thiagonascimento.saleservice.sale.repository.find;

import com.thiagonascimento.saleservice.sale.domain.FindSaleParameters;
import com.thiagonascimento.saleservice.sale.domain.Sale;
import com.thiagonascimento.saleservice.sale.repository.find.criteria.CriteriaGenerator;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import reactor.core.publisher.Flux;

import java.util.List;

@AllArgsConstructor
public class SaleFindRepositoryImpl implements SaleFindRepository {

    private ReactiveMongoTemplate mongoTemplate;
    private List<CriteriaGenerator> criteriaGenerators;

    @Override
    public Flux<Sale> find(FindSaleParameters parameters) {
        var criteria = new Criteria();
        criteriaGenerators.forEach((CriteriaGenerator criteriaGenerator) -> {
            if (criteriaGenerator.parameterIsPresent(parameters))
                criteriaGenerator.addCriteria(parameters, criteria);
        });
        return mongoTemplate.find(Query.query(criteria), Sale.class);
    }
}
