package com.example.demo.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.data.PostData;
import com.example.demo.repository.PostRepository;


@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	//find by id
	public Optional<PostData> findById(long id) 
	{
		return postRepository.findById(id);
		}
	

	//post method
	public PostData postData(@RequestBody PostData data)
	{
			return postRepository.save(data);
	}
	
	//get the list
	public List<PostData> getData()
	{
		return postRepository.findAll();
	}

	//delete the data
	public void deleteId(long id)
	{
		postRepository.deleteById(id);
		 }
	
	//update the record
	public PostData updateData(PostData studd,long id) 
	{
		//PostData es=postRepository.findById(id);
		
	//	es.setTitle(studd.getTitle());
	//	es.setBody(studd.getBody());
		return postRepository.save(studd);
		
		 //return es;
		
	}
	


}
