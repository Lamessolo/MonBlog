package com.monblog.app.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="posts", uniqueConstraints = {@UniqueConstraint(columnNames = {"title"})})
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="title", nullable=false)
	private String title;
	
	@Column(name="description")
	private String description;
	
	@Column(name="content", nullable=false,length = 1000)
	private String content;
	
	@Column(name="author", nullable=false)
	private String author;
	
	@Column(name="image_url")
	public String imageUrl;
	
	@Column(name="url_handle")
	public String urlHandle;
	
	@Column(name="date_published")
	public Date publishedDate;
	
	
	
}
