package com.example.posbackendspring.dto.impl;


import com.example.posbackendspring.dto.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDTO implements OrderStatus {
    private String orderId;
    private String customerId;
    private LocalDate orderDate;
    private List<OrderDetaisDTO> orderDetails;
}
