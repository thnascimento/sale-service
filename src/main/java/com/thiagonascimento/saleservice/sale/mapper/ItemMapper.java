package com.thiagonascimento.saleservice.sale.mapper;

import com.thiagonascimento.saleservice.sale.domain.Item;
import com.thiagonascimento.saleservice.sale.dto.ItemDTO;

import java.util.List;
import java.util.stream.Collectors;

public class ItemMapper {

    public static Item mapToModel(ItemDTO itemDTO) {
        return Item.builder()
                .id(itemDTO.getId())
                .price(itemDTO.getPrice())
                .quantity(itemDTO.getQuantity())
                .build();
    }

    public static List<Item> mapToModelList(List<ItemDTO> itemDTOList) {
        return itemDTOList.stream().map(ItemMapper::mapToModel).collect(Collectors.toList());
    }

    public static ItemDTO mapToDTO(Item item) {
        return ItemDTO.builder()
                .id(item.getId())
                .price(item.getPrice())
                .quantity(item.getQuantity())
                .build();
    }

    public static List<ItemDTO> mapToDTOList(List<Item> item) {
        return item.stream().map(ItemMapper::mapToDTO).collect(Collectors.toList());
    }
}
