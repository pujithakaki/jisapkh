package com.example.demo.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.demo.data.PostData;
import com.example.demo.service.PostService;

@SpringBootTest
	public class ControllerTest {
		
		@Autowired
		PostController postController;
		
		@MockBean
		PostService postService;
		
		
		
		
		@Test
		public void  testStdCreation(){
			PostData st = new PostData();
			when(postService.postData(any(PostData.class))).thenReturn(st);
			//(ResponseEntity.status(HttpStatus.OK).build());
			//PostData st = new PostData();
			st.setUserId(12345);
			st.setTitle("khjjj");
			st.setBody("hi");
			PostData ps = postController.create(st);
			//Assertions.assertEquals(ps,HttpStatus.OK);
		}
		
		@Test
		public void testGetId() {
			
			PostData st=new PostData();
			//when(studentService.findById(23L));
		//	when(studentService.findById(23)).thenReturn(ResponseEntity.status(HttpStatus.OK).build());
		//	when(postService.findById(23L)).thenReturn(Optional.ofNullable(new PostData()));
			when(postService.findById(23L)).thenReturn(Optional.of(st));
			Optional<PostData> responseEntity = postController.getId(23L);
			//Assertions.assertEquals(responseEntity,HttpStatus.OK);
			
		}
		
		
		@Test
		public void testUpdate()  {
			//when(postService.updateData(any(PostData.class), eq(23L))).thenReturn(ResponseEntity.status(HttpStatus.OK).build());
			PostData st = new PostData();
			st.setUserId(12345);
			st.setTitle("khjjj");
			st.setBody("hi");
			when(postService.updateData(st,23L)).thenReturn((st));
			PostData responseEntity = postController.updateData(st,23L);
			//Assertions.assertEquals(responseEntity,HttpStatus.OK);
			
		}
		
		@Test
		public void testGetAll() {
			when(postService.getData()).thenReturn(Arrays.asList(new PostData()));
			
			List<PostData> responseEntity=postController.getData();
			assertThat(responseEntity).size().isGreaterThan(0);
			
			
		}
	
		@Test 
		public void testDelete(){
			doNothing().when(postService).deleteId(anyLong());
			postService.deleteId(23L);
			//thenReturn(Optional.ofNullable(st));
			 postController.deleteId(23L);
			//Assertions.assertEquals("Deleted Successfuly",HttpStatus.OK);
		
			//.verify(studentController, times(1)).deleteById(id);

		}
}
