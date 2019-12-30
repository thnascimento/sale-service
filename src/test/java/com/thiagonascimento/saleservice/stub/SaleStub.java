package com.thiagonascimento.saleservice.stub;

import com.thiagonascimento.saleservice.sale.domain.Item;
import com.thiagonascimento.saleservice.sale.domain.Sale;

import java.util.Arrays;

public class SaleStub {

    public static Sale mostExpensiveSale() {
        return Sale.builder()
                .items(Arrays.asList(
                        buildItem("1", 10, 100.0),
                        buildItem("2", 30, 2.50),
                        buildItem("3", 40, 100.0)))
                .salesmanName("Pedro")
                .totalValue(120.0)
                .id("mostExpensiveId")
                .build();
    }

    public static Sale notMostExpensiveSale() {
        return Sale.builder()
                .items(Arrays.asList(
                        buildItem("1", 34, 10.0),
                        buildItem("2", 33, 1.50),
                        buildItem("3", 40, 0.10)))
                .salesmanName("Paulo")
                .totalValue(50.0)
                .id("notMostExpensiveId")
                .build();
    }

    private static Item buildItem(String id, Integer quantity, Double value) {
        return Item.builder()
                .id(id)
                .quantity(quantity)
                .price(value)
                .build();
    }
}
