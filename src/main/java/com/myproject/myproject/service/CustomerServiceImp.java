package com.myproject.myproject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.myproject.controller.CustomerDTO;
import com.myproject.myproject.dao.CustomerRepo;
import com.myproject.myproject.dao.entity.CustomerEntity;

@Service
public class CustomerServiceImp implements CustomerService{
	
	@Autowired
	private CustomerRepo customerDao;
	
	@Override
	public void deleteById(int id) {
		 customerDao.deleteById(id);
	}

	@Override
	public void save(CustomerDTO customerDto) {
		CustomerEntity customers= new CustomerEntity();
		BeanUtils.copyProperties(customerDto, customers);
		customerDao.save(customers);
		
	}

	@Override
	public List<CustomerDTO> findAll() {
		List<CustomerEntity> list= customerDao.findAll();
		List<CustomerDTO> dtos= new ArrayList<>();
		for(CustomerEntity customers: list) {
			CustomerDTO dto= new CustomerDTO();
			BeanUtils.copyProperties(customers, dto);
			dtos.add(dto);
			
		}
		return dtos; 
	}

	@Override
	public CustomerDTO findById(int id) {
		Optional<CustomerEntity> customer= customerDao.findById(id);
		CustomerDTO dto= new CustomerDTO();
		if(customer.isPresent()) {
			BeanUtils.copyProperties(customer.get(), dto);
			
		}
		return dto;
	}

	@Override
	public void update(CustomerDTO customerDto) {
		CustomerEntity customer= new CustomerEntity();
		BeanUtils.copyProperties(customerDto, customer);
		customerDao.save(customer);
	}

	@Override
	public CustomerDTO findByNameAndPassword(String name, String password) {
		Optional<CustomerEntity> customer= customerDao.findByNameAndPassword(name, password);
		CustomerDTO customerDto= null;
		if(customer.isPresent()) {
			customerDto= new CustomerDTO();
			BeanUtils.copyProperties(customer.get(), customerDto);
		}
		return customerDto;
	}

	@Override
	public CustomerDTO findByName(String name) {
		Optional<CustomerEntity> customer= customerDao.findByName(name);
		CustomerDTO customerDto= null;
		if(customer.isPresent()) {
			customerDto= new CustomerDTO();
			BeanUtils.copyProperties(customer.get(), customerDto);
		}
		return customerDto;
	}

	@Override
	public void updataPassword(String name, String password) {
		Optional<CustomerEntity> optional= customerDao.findByName(name);
		if(optional.isPresent()) {
			CustomerEntity entity= optional.get();
			entity.setPassword(password);
		}
		
	}

}
