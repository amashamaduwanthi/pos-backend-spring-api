package com.example.posbackendspring.service;

import com.example.posbackendspring.dto.impl.OrderDTO;
import com.example.posbackendspring.dto.impl.OrderDetaisDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    void saveOrder(OrderDTO orderDto, List<OrderDetaisDTO> orderDetails);
}
