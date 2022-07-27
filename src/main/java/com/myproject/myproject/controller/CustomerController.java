package com.myproject.myproject.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.myproject.service.CustomerService;
import com.myproject.myproject.service.security.UserDetailsImpl;
import com.myproject.myproject.service.security.jwt.JwtUtils;

@RestController
@RequestMapping("/org")
@CrossOrigin(origins="http://localhost:4200/")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	  @Autowired
	  PasswordEncoder encoder;

	  @Autowired
	  JwtUtils jwtUtils;
	
	
	@PostMapping("/auth")
	  public ResponseEntity<?> authenticateUser(@Valid @RequestBody AuthDTO loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
		        new UsernamePasswordAuthenticationToken(loginRequest.getName(), loginRequest.getPassword()));
	        //This line means you are authenticated and your role ready for u
		    SecurityContextHolder.getContext().setAuthentication(authentication);
		    
		    String jwt = jwtUtils.generateJwtToken(authentication);
	    
	    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();    
	    List<String> roles = userDetails.getAuthorities().stream()
	        .map(item -> item.getAuthority())
	        .collect(Collectors.toList());

	    return ResponseEntity.ok(new JwtResponse(jwt, 
	                         userDetails.getId(), 
	                         userDetails.getUsername(), 
	                         userDetails.getDob(), 
	                         roles));
	  }
	
	
	@DeleteMapping("/customers/{id}")
	public void deleteCustomer(@PathVariable int id) {
		
		customerService.deleteById(id);
		
		
	}
	
	@PostMapping("/customers")
	@ResponseStatus(HttpStatus.CREATED)
	public void saveCustomer(@RequestBody CustomerDTO customer) {
			 customerService.save(customer);
				
		
	}
	
	@GetMapping("/customers")
	public List<CustomerDTO> findAllCustomer(){
		List<CustomerDTO> customers= customerService.findAll();
		return customers;
		
	}
	@GetMapping("/customers/{id}")
	public CustomerDTO findById(@PathVariable int id) {
		CustomerDTO customer= customerService.findById(id);
		return customer;
		
		
	}
	
	@PutMapping("customers")
	@ResponseStatus(HttpStatus.OK)
	public String editCustomer(@RequestBody CustomerDTO customer) {
		customerService.update(customer);
		return "Updated Successfully";
		
	}
	
	@GetMapping("/customer/{name}")
	public CustomerDTO getCustomerByName(@PathVariable String name) {
		return customerService.findByName(name);
		
	}
	/*
	@PatchMapping("/customers")
	public void editPassword(@RequestParam String name, @RequestParam String password) {
		
		customerService.updataPassword(name, password);
	}
	*/
	@PatchMapping("/customers/{name}")
	public void editPassword(@PathVariable String name, @RequestBody String password) {
		
		customerService.updataPassword(name, password);
	}
	
	
}
