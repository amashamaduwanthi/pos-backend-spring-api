package com.example.posbackendspring.service;

import com.example.posbackendspring.dto.impl.ItemDTO;

public interface ItemService {
    void saveItem(ItemDTO itemDTO);

    ItemDTO getItem(String itemCode);

}
