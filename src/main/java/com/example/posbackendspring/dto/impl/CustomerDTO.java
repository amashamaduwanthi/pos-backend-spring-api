package com.example.posbackendspring.dto.impl;


import com.example.posbackendspring.dto.CustomerStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDTO implements CustomerStatus {
    private String customerId;
    private String name;
    private String address;
    private String tel;
    private String regDate;


}
