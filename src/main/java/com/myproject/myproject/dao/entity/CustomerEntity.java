package com.myproject.myproject.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customers")
public class CustomerEntity {
		
	
	
		private int id;
		private String name;
		private String password;
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		private String address;
		private String phone;
		private String dob;
		public String image;
		public String getImage() {
			return image;
		}
		public void setImage(String image) {
			this.image = image;
		}
		
		@Id
		@GeneratedValue(strategy= GenerationType.AUTO)
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		
		@Column(name="name")
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getDob() {
			return dob;
		}
		public void setDob(String dob) {
			this.dob = dob;
		}
		public CustomerEntity(int id, String name, String password, String address, String phone, String dob, String image) {
			super();
			this.id = id;
			this.name = name;
			this.password = password;
			this.address = address;
			this.phone = phone;
			this.dob = dob;
			this.image = image;
		}
		public CustomerEntity() {
			// TODO Auto-generated constructor stub
		}

		

		
		
	
}
