package com.example.posbackendspring.dto.impl;

import lk.ijse.posbackend.pos_backend_spring.dto.CustomerStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDTO implements CustomerStatus {
    private String nic;
    private String name;
    private String address;
    private String tel;
    private String regDate;

}
