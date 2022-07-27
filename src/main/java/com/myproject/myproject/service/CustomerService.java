package com.myproject.myproject.service;

import java.util.List;

import com.myproject.myproject.controller.CustomerDTO;

public interface CustomerService {
	void deleteById(int id);
	
	public void save(CustomerDTO customerDto);
	
	public List<CustomerDTO> findAll();
	
	public CustomerDTO findById(int id);
	
	void update(CustomerDTO customerDto);
	
	
	
	public CustomerDTO findByName(String name);
	
	void updataPassword(String name, String password);

	CustomerDTO findByNameAndPassword(String name, String password);
}
