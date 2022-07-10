package com.example.demo.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.example.demo.request.UserDataRequest;

@Entity(name="user")
@Table(name="user")
public class UserData {
		
				@Id
			    @GeneratedValue(strategy = GenerationType.IDENTITY)
				private long id;
				
				@Column(unique=true)
				private String name;
					
				@Column
				private String username;
				
				@Column
				private String email;
				
				@OneToOne
				@JoinColumn(name="address_id")
				private Address address;
				
				@Column
				private String phone;
				
				@Column
				private String website;
				
				@Column
				private String company;
				
				public UserData(UserDataRequest request) {
				super();
				//this.id = request.id;
				this.name = request.getName();
				this.username = request.getUsername();
				this.email = request.getEmail();
				this.phone = request.getPhone();
				this.website = request.getWebsite();
				this.company = request.getCompany();
}

				

				public UserData(long id, String name, String username, String email, Address address, String phone,
						String website, String company) {
					super();
					this.id = id;
					this.name = name;
					this.username = username;
					this.email = email;
					this.address = address;
					this.phone = phone;
					this.website = website;
					this.company = company;
				}



				public long getId() {
					return id;
				}

				public void setId(long id) {
					this.id = id;
				}

				public String getName() {
					return name;
				}

				public void setName(String name) {
					this.name = name;
				}

				public String getUsername() {
					return username;
				}

				public void setUsername(String username) {
					this.username = username;
				}

				public String getEmail() {
					return email;
				}

				public void setEmail(String email) {
					this.email = email;
				}

				public Address getAddress() {
					return address;
				}

				public void setAddress(Address address) {
					this.address = address;
				}

				public String getPhone() {
					return phone;
				}

				public void setPhone(String phone) {
					this.phone = phone;
				}

				public String getWebsite() {
					return website;
				}

				public void setWebsite(String website) {
					this.website = website;
				}

				public String getCompany() {
					return company;
				}

				public void setCompany(String company) {
					this.company = company;
				}

								
				
				

}
