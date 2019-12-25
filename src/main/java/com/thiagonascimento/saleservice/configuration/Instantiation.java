package com.thiagonascimento.saleservice.configuration;

import com.thiagonascimento.saleservice.sale.repository.SaleRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class Instantiation implements CommandLineRunner {

    private SaleRepository saleRepository;

    @Override
    public void run(String... args) throws Exception {

        saleRepository.deleteAll();


    }
}
