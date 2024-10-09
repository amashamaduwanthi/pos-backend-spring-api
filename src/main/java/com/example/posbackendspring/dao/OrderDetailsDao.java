package com.example.posbackendspring.dao;

import lk.ijse.posbackend.pos_backend_spring.entity.impl.OrderDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailsDao extends JpaRepository<OrderDetailsEntity,String> {
}
