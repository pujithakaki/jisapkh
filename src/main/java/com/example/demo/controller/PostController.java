package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.data.PostData;
import com.example.demo.service.PostService;



@Controller
public class PostController {
	

	@Autowired
	private PostService postService;
	
	@GetMapping("/post/{id}")
	public Optional<PostData> getId(@PathVariable long id) 
	{
		return postService.findById(id);
		
	//	return postService.findById(id));

		
	}
	
	
	@GetMapping("/post/findAll")
	public List<PostData> getData()
	{
		List<PostData> student= postService.getData();
		return student;
	}

	
	@PostMapping("/post")
	public PostData create(@RequestBody PostData post)
	{
		//ResponseEntity<Object> savedStudent=postService.regForm(post);
		return postService.postData(post);
		
		
		}


	@DeleteMapping("/post/delete/{id}")
	public String deleteId(long id ) 
	{
		 postService.deleteId(id);
		return "Deleted Successfully";
		}
	
	
    @PutMapping("/post/update/{id}")
    public PostData updateData(@RequestBody PostData post,@PathVariable long id) 
    {
	  return postService.updateData(post,id);
      }


}
