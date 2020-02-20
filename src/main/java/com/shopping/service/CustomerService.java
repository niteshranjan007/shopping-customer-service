package com.shopping.service;

import java.util.List;

import com.shopping.exception.RecordNotFoundException;
import com.shopping.entity.CustomerEntity;

public interface CustomerService {
	
	public List<CustomerEntity> getAllCustomers();
	public CustomerEntity createOrUpdateCustomer(CustomerEntity entity) throws RecordNotFoundException;
	public CustomerEntity getCustomerById(Long id) throws RecordNotFoundException ;
	public void deleteCustomerById(Long id) throws RecordNotFoundException ;

}
