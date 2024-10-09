package com.example.posbackendspring.entity.impl;

import jakarta.persistence.*;
import lk.ijse.posbackend.pos_backend_spring.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order-details")
public class OrderDetailsEntity implements SuperEntity {
    @Id
    private String id;
    private LocalDate date;
    private String customerId;
    private String customerName;
    private String customerAddress;
    private String customerTel;
    private int orderQTY;
    private double unitPrice;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "itemCode")
    private ItemEntity item;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "orderID")
    private OrderEntity order;
}
