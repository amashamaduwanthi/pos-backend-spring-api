package com.example.posbackendspring.dao;

import lk.ijse.posbackend.pos_backend_spring.entity.impl.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemDao extends JpaRepository<ItemEntity,String> {
}
