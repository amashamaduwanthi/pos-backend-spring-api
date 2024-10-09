package com.example.posbackendspring.dto.impl;


import com.example.posbackendspring.dto.OrderStatus;
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
