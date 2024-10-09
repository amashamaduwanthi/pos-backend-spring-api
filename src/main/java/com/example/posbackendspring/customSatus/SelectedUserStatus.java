package com.example.posbackendspring.customSatus;


import lk.ijse.posbackend.pos_backend_spring.dto.CustomerStatus;
import lk.ijse.posbackend.pos_backend_spring.dto.ItemStatus;
import lk.ijse.posbackend.pos_backend_spring.dto.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SelectedUserStatus implements CustomerStatus, ItemStatus, OrderStatus {
    private int statusCode;
    private String statusMessage;
}
