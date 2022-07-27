package com.myproject.myproject.service.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myproject.myproject.dao.CustomerRepo;
import com.myproject.myproject.dao.entity.CustomerEntity;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
  
  @Autowired
  private CustomerRepo signupDao;
  
  @Autowired
  PasswordEncoder encoder;
  
  
  @Override
  @Transactional
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	  Optional<CustomerEntity> optional= signupDao.findByName(username);
	  if(optional.isEmpty()) {
		  throw new UsernameNotFoundException("User Not Found with username: " + username);
	  }
	  CustomerEntity signup =optional.get();
	  signup.setPassword(encoder.encode("test"));
	  return UserDetailsImpl.build(signup);
  }

}
