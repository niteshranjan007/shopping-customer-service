package com.shopping.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.entity.CustomerEntity;
import com.shopping.exception.RecordNotFoundException;
import com.shopping.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
    CustomerRepository repository;
     
    public List<CustomerEntity> getAllCustomers()
    {
        List<CustomerEntity> customerList = repository.findAll();
         
        if(customerList.size() > 0) {
            return customerList;
        } else {
            return new ArrayList<CustomerEntity>();
        }
    }
     
    public CustomerEntity getCustomerById(Long id) throws RecordNotFoundException 
    {
        Optional<CustomerEntity> customer = repository.findById(id);
         
        if(customer.isPresent()) {
            return customer.get();
        } else {
            throw new RecordNotFoundException("No customer record exist for given id");
        }
    }
     
    public CustomerEntity createOrUpdateCustomer(CustomerEntity entity) throws RecordNotFoundException 
    {
        Optional<CustomerEntity> customer = repository.findById(entity.getId());
         
        if(customer.isPresent()) 
        {
            CustomerEntity newEntity = customer.get();
            newEntity.setEmail(entity.getEmail());
            newEntity.setFirstName(entity.getFirstName());
            newEntity.setLastName(entity.getLastName());
 
            newEntity = repository.save(newEntity);
             
            return newEntity;
        } else {
            entity = repository.save(entity);
             
            return entity;
        }
    } 
     
    public void deleteCustomerById(Long id) throws RecordNotFoundException 
    {
        Optional<CustomerEntity> customer = repository.findById(id);
         
        if(customer.isPresent()) 
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No customer record exist for given id");
        }
    } 
}