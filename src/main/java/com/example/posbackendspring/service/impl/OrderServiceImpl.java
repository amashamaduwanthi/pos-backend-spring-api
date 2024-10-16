package com.example.posbackendspring.service.impl;


import com.example.posbackendspring.dao.CustomerDao;
import com.example.posbackendspring.dao.ItemDao;
import com.example.posbackendspring.dao.OrderDao;
import com.example.posbackendspring.dao.OrderDetailsDao;
import com.example.posbackendspring.dto.impl.OrderDTO;
import com.example.posbackendspring.dto.impl.OrderDetaisDTO;
import com.example.posbackendspring.entity.impl.ItemEntity;
import com.example.posbackendspring.entity.impl.OrderDetailsEntity;
import com.example.posbackendspring.entity.impl.OrderEntity;
import com.example.posbackendspring.exception.DataPersistException;
import com.example.posbackendspring.service.OrderService;
import com.example.posbackendspring.util.AppUtil;
import com.example.posbackendspring.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private OrderDetailsDao orderDetailsDao;
    @Autowired
    private ItemDao itemDao;
    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private Mapping mapping;

    @Override
    public void saveOrder(OrderDTO orderDto, List<OrderDetaisDTO> orderDetails) {
        orderDto.setOrderId(AppUtil.generateOrderId());
        OrderEntity save_order = orderDao.save(mapping.toOrderEntity(orderDto));

        if(save_order==null){
            throw new DataPersistException("Order not saved !!!");
        }
        for(OrderDetaisDTO orderDetailsDto:orderDetails){
            orderDetailsDto.setDetailsId(AppUtil.generateOrderDetailsId());
            OrderDetailsEntity orderDetailsEntity = mapping.toOrderDetailsEntity(orderDetailsDto);
            orderDetailsEntity.setOrder(save_order);
            orderDetailsDao.save(orderDetailsEntity);

            Optional<ItemEntity> choose_item = itemDao.findById(String.valueOf(orderDetailsDto.getOrderQty()));

            if(choose_item.isPresent()){
                ItemEntity itemEntity = choose_item.get();
                int update_Qty = itemEntity.getQty() - orderDetailsDto.getOrderQty();
                if (update_Qty<=0) {
                    throw new DataPersistException("Item is out of stock :"+ orderDetailsDto.getItem());
                }
                itemEntity.setQty(update_Qty);
                itemDao.save(itemEntity);
            }

        }
    }


}
