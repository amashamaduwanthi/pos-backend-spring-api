package com.example.posbackendspring.dto.impl;

import lk.ijse.posbackend.pos_backend_spring.dto.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDTO implements OrderStatus {
    private String id;
    private String date;
    private double discount_value;
    private double sub_total;
    private String customer_id;
}
