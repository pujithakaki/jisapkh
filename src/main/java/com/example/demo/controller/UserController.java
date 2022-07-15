package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.demo.data.UserData;
import com.example.demo.request.UserDataRequest;
import com.example.demo.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/user/{id}")
	public Optional<UserData> getId(@PathVariable long id) 
	{
		return userService.findById(id);
		
	}
	
	
	@GetMapping("/user/findAll")
	public List<UserData> getData()
	{
		List<UserData> student= userService.getData();
		return student;
	}

	
	@PostMapping("/user")
	public ResponseEntity<UserData> create(@RequestBody UserDataRequest post)
	{
		//ResponseEntity<Object> savedStudent=postService.regForm(post);
		return userService.postData(post);
		
		
		}


	@DeleteMapping("/user/delete/{id}")
	public String deleteId(long id ) 
	{
		userService.deleteId(id);
		return "Deleted Successfully";
		//return new ResponseEntity<Object>("Deleted Successfully");
		}
	
	
    @PutMapping("/user/update/{id}")
    public UserData updateData(@RequestBody UserData data,@PathVariable long id) 
    {
	  return userService.updateData(data,id);
      }




}
