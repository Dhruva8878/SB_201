package com.masai.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Comment;

public interface CommentDAO extends JpaRepository<Comment, Integer>{

}
