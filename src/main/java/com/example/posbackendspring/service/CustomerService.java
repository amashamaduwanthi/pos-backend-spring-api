package com.example.posbackendspring.service;

import com.example.posbackendspring.dto.impl.CustomerDTO;

import java.util.List;

public interface CustomerService {
    void saveCustomer(CustomerDTO customerDTO);

    void deleteCustomer(String customerId);

    void updateCustomer(String customerId, CustomerDTO updatedCustomerDto);

    CustomerDTO getCustomer(String customerId);

    List<CustomerDTO> getAllCustomers();
}
