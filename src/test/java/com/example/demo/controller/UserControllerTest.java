package com.example.demo.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import com.example.demo.data.PostData;
import com.example.demo.data.UserData;
import com.example.demo.request.UserDataRequest;
import com.example.demo.service.PostService;
import com.example.demo.service.UserService;


@SpringBootTest
public class UserControllerTest {
	
	@Autowired
	UserController userController;
	
	@MockBean
	UserService userService;
	
	
	
	
	@Test
	public void  testStdCreation(){
		UserDataRequest st = new UserDataRequest();
		when(userService.UserData(any(UserData.class))).thenReturn(st);
		//(ResponseEntity.status(HttpStatus.OK).build());
		//PostData st = new PostData();
		st.setName("puji");
		st.setUsername("khjjj");
		st.setEmail("hi");
		st.setAddress("gh");
		st.setPhone("1235");
		st.setWebsite("h");
		st.setCompany("g");
		ResponseEntity<UserData> ps = userController.create(st);
		//Assertions.assertEquals(ps,HttpStatus.OK);
	}
	
	@Test
	public void testGetId() {
		
		Optional<UserData> st=Optional.empty();
		when(userService.findById(23L)).thenReturn(st);
		Optional<UserData> responseEntity = userController.getId(23L);
		//Assertions.assertEquals(responseEntity,HttpStatus.OK);
		
	}
	
	
	@Test
	public void testUpdate()  {
		//when(postService.updateData(any(PostData.class), eq(23L))).thenReturn(ResponseEntity.status(HttpStatus.OK).build());
		UserData st = new UserData();
		st.setName("puji");
		st.setUsername("khjjj");
		st.setEmail("hi");
		st.setPhone("1235");
		st.setWebsite("h");
		st.setCompany("g");
		when(userService.updateData(st,23L)).thenReturn((st));
		UserData responseEntity = userController.updateData(st,23L);
		//Assertions.assertEquals(responseEntity,HttpStatus.OK);
		
	}
	
	@Test
	public void testGetAll() {
		when(userService.getData()).thenReturn(Arrays.asList(new UserData()));
		
		List<UserData> responseEntity=userController.getData();
		assertThat(responseEntity).size().isGreaterThan(0);
		
		
	}

	@Test 
	public void testDelete(){
		doNothing().when(userService).deleteId(anyLong());
		userService.deleteId(23L);
		//thenReturn(Optional.ofNullable(st));
		userController.deleteId(23L);
		//Assertions.assertEquals("Deleted Successfuly",HttpStatus.OK);
	
		//.verify(studentController, times(1)).deleteById(id);

	}


}
