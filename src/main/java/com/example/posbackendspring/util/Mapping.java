package com.example.posbackendspring.util;



import com.example.posbackendspring.dto.impl.CustomerDTO;
import com.example.posbackendspring.dto.impl.ItemDTO;
import com.example.posbackendspring.entity.impl.CustomerEntity;
import com.example.posbackendspring.entity.impl.ItemEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapping {
    @Autowired
   private ModelMapper modelMapper;
    //modelmapper thiyenne userdto entity map krnn

    //for use mapping
    public CustomerEntity toCustomerEntity(CustomerDTO customerDTO){
        return modelMapper.map(customerDTO,CustomerEntity.class);
    }
    public CustomerDTO toUserDto(CustomerEntity customerEntity){
        return modelMapper.map(customerEntity,CustomerDTO.class);
    }
    public List<CustomerDTO> asUserDtoList(List<CustomerEntity>customerEntities){
        return modelMapper.map(customerEntities, new TypeToken<List<CustomerDTO>>() {}.getType());
    }

    public ItemEntity toItemEntity(ItemDTO itemDTO){
        return modelMapper.map(itemDTO,ItemEntity.class);
    }
    public ItemDTO toItemDto(ItemEntity itemEntity){
        return modelMapper.map(itemEntity,ItemDTO.class);
    }
    public List<ItemDTO> asItemDtoList(List<ItemEntity>itemEntities){
        return modelMapper.map(itemEntities, new TypeToken<List<ItemDTO>>() {}.getType());
    }













}