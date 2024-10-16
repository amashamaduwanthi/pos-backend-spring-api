package com.example.posbackendspring.dto.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReqOrderDto {
    private OrderDTO orderDto;
    private List<OrderDetaisDTO> orderDetails;
}
