package com.monblog.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.monblog.app.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {

	
	
}
