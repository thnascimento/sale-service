package com.thiagonascimento.saleservice.configuration;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

@Configuration
@NoArgsConstructor
public class MongoConfiguration {

    @Value(value = "${spring.data.mongodb.uri}")
    private String databaseHost;
    @Value(value = "sale_service_db")
    private String databaseName;

    @Bean
    public MongoClient reactiveMongoClient() {
        return MongoClients.create(databaseHost);
    }

    @Bean
    public ReactiveMongoTemplate reactiveMongoTemplate() {
        return new ReactiveMongoTemplate(reactiveMongoClient(), databaseName);
    }
}
