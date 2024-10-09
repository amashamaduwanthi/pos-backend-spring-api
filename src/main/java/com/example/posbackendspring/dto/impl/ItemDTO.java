package com.example.posbackendspring.dto.impl;

import lk.ijse.posbackend.pos_backend_spring.dto.ItemStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemDTO implements ItemStatus {
    private String code;
    private String name;
    private String description;
    private String qty;
    private String unitPrice;
}
