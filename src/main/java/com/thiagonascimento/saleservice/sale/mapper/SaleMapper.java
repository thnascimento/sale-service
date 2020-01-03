package com.thiagonascimento.saleservice.sale.mapper;

import com.thiagonascimento.saleservice.sale.domain.Sale;
import com.thiagonascimento.saleservice.sale.dto.SaleDTO;

public class SaleMapper {

    public static Sale mapToModel(SaleDTO saleDTO) {
        return Sale.builder()
                .items(ItemMapper.mapToModelList(saleDTO.getItems()))
                .salesmanName(saleDTO.getSalesmanName())
                .build();
    }

    public static SaleDTO mapToDTO(Sale sale) {
        return SaleDTO.builder()
                .id(sale.getId())
                .items(ItemMapper.mapToDTOList(sale.getItems()))
                .salesmanName(sale.getSalesmanName())
                .totalValue(sale.getTotalValue())
                .creationDate(sale.getCreationDate())
                .build();
    }
}
