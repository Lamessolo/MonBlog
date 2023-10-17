package com.monblog.app.dto;


import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {

	private long id;
		
	private String title;
	
	private String description;
		
	private String content;
	
	private String author;
	
	public String imageUrl;
	
	public String urlHandle;
	
	public Date publishedDate;
}
