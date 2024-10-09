package com.example.posbackendspring.dto.impl;

import lk.ijse.posbackend.pos_backend_spring.dto.OrderDetailsStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDetaisDTO implements OrderDetailsStatus {
    private String order_id;
    private String item_id;
    private int qty;
    private double unitPrice;
    private double total;
}
