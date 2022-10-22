package com.masai.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Post;

public interface PostDAO extends JpaRepository<Post, Integer> {

}
