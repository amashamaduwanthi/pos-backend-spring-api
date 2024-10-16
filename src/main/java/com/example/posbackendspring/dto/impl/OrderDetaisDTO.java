package com.example.posbackendspring.dto.impl;


import com.example.posbackendspring.dto.OrderDetailsStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDetaisDTO implements OrderDetailsStatus {
    private String detailsId;
    private OrderDTO order;
    private ItemDTO item;
    private int orderQty;
    private double unitPrice;
}
