package com.example.posbackendspring.service.impl;


import com.example.posbackendspring.dao.CustomerDao;
import com.example.posbackendspring.dto.impl.CustomerDTO;
import com.example.posbackendspring.entity.impl.CustomerEntity;
import com.example.posbackendspring.exception.DataPersistException;
import com.example.posbackendspring.exception.NoteNotFoundException;
import com.example.posbackendspring.service.CustomerService;
import com.example.posbackendspring.util.AppUtil;
import com.example.posbackendspring.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private Mapping customerMapping;
    @Override
    public void saveCustomer(CustomerDTO customerDTO) {
        customerDTO.setCustomerId(AppUtil.generateCustomerId());
        CustomerEntity savedNote =
                customerDao.save(customerMapping.toCustomerEntity(customerDTO));
        if(savedNote == null){
            throw new DataPersistException("Customer not saved");
        }

    }

    @Override
    public void deleteCustomer(String customerId) {
        Optional<CustomerEntity> foundNote=customerDao.findById(customerId);
        if(!foundNote.isPresent()){
            throw new NoteNotFoundException("Customer with id " + customerId + " not found");
        }else {
            customerDao.deleteById(customerId);
        }
    }

    @Override
    public void updateCustomer(String customerId, CustomerDTO updatedCustomerDto) {
        Optional<CustomerEntity>foundCustomer=customerDao.findById(customerId);
        if(!foundCustomer.isPresent()){
            throw new NoteNotFoundException("Customer with id " + customerId + " not found");
        }else {
            foundCustomer.get().setName(updatedCustomerDto.getName());
            foundCustomer.get().setAddress(updatedCustomerDto.getAddress());
            foundCustomer.get().setTel(updatedCustomerDto.getTel());
           foundCustomer.get().setRegDate(updatedCustomerDto.getRegDate());
        }
    }

    @Override
    public CustomerDTO getCustomer(String customerId) {
        CustomerEntity customer = customerDao.getReferenceById(customerId);

        return customerMapping.toUserDto(customer);
    }


}
