package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.data.Address;
import com.example.demo.data.UserData;
import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.request.UserDataRequest;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AddressRepository addressRepository;
	
	//find by id
	public Optional<UserData> findById(long id) 
	{
		return userRepository.findById(id);
		}
	

	//post method
	public ResponseEntity<UserData> postData(@RequestBody UserDataRequest req)
	{
		Address address = new Address();
		address.setStreet(req.getAddress());
		address.setSuite(req.getAddress());
		address.setCity(req.getAddress());
		address.setZipcode(req.getAddress());
		
		address = addressRepository.save(address);
		
		UserData user = new UserData(req);
		user.setAddress(address);
		user = userRepository.save(user);
		return new ResponseEntity<UserData>(user, HttpStatus.CREATED);
	
			//return userRepository.save(user);
	}
	
	//get the list
	public List<UserData> getData()
	{
		return userRepository.findAll();
	}

	//delete the data
	public void deleteId(long id)
	{
		userRepository.deleteById(id);
		 }
	
	//update the record
	public UserData updateData(UserData studd,long id) 
	{
		return userRepository.save(studd);
		
		 //return es;
	}
}
