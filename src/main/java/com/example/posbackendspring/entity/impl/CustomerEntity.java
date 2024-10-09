package com.example.posbackendspring.entity.impl;

import jakarta.persistence.*;
import lk.ijse.posbackend.pos_backend_spring.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class CustomerEntity implements SuperEntity {
    @Id
    private String customerId;
    private String name;
    private String address;
    private String tel;
    private String regDate;
    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private List<OrderEntity> orderList;


}
