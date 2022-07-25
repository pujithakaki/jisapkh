package com.example.demo.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="post")
@Table(name="post")
public class PostData {
	
	        @Column
	        private long userId;
	
			@Id
		    @GeneratedValue(strategy = GenerationType.IDENTITY)
			private long id;
			
			@Column(unique=true)
			private String title;
				
			@Column
			private String body;
			
			public PostData() {
				super();
			}

			public PostData(long userId, long id, String title, String body) {
				super();
				this.userId = userId;
				this.id = id;
				this.title = title;
				this.body = body;
			}

			public long getUserId() {
				return userId;
			}

			public void setUserId(long userId) {
				this.userId = userId;
			}

			public long getId() {
				return id;
			}

			public void setId(long id) {
				this.id = id;
			}

			public String getTitle() {
				return title;
			}

			public void setTitle(String title) {
				this.title = title;
			}

			public String getBody() {
				return body;
			}

			public void setBody(String body) {
				this.body = body;
			}
			
			
			
			
			


}
