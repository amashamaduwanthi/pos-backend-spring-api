package com.example.posbackendspring.customSatus;



import com.example.posbackendspring.dto.CustomerStatus;
import com.example.posbackendspring.dto.ItemStatus;
import com.example.posbackendspring.dto.OrderStatus;
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
