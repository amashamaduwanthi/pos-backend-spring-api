package com.example.posbackendspring.service;

import com.example.posbackendspring.dto.impl.ItemDTO;

import java.util.List;

public interface ItemService {
    void saveItem(ItemDTO itemDTO);

    ItemDTO getItem(String itemCode);

    void updateItem(String itemCode, ItemDTO updateditemDto);

    void deleteItem(String itemCode);

    List<ItemDTO> getAllItems();
}
