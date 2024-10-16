package com.example.posbackendspring.controller;

import com.example.posbackendspring.dto.impl.ReqOrderDto;
import com.example.posbackendspring.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/placeOrder")
public class PlaceOrderController {
    @Autowired
    private OrderService orderService;


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveOrder(@RequestBody ReqOrderDto reqOrderDto){

        orderService.saveOrder(reqOrderDto.getOrderDto(),reqOrderDto.getOrderDetails());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
