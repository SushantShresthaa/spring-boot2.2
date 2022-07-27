package com.myproject.myproject.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myproject.myproject.dao.entity.CustomerEntity;


@Repository
public interface CustomerRepo extends JpaRepository<CustomerEntity, Integer>{
	
	public Optional<CustomerEntity> findByName(String name);
	
	public Optional<CustomerEntity> findByNameAndPassword(String name, String password);

}
