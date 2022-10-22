package com.masai.service;

import java.util.List;

import com.masai.model.Comment;

public interface CommentService {
	
	public Comment postComment(Comment comment);
	
	public Comment updateComment(Comment comment);
	
	public Comment getCommentById(Integer id);
	
	public List<Comment> getAllComments();
	
	public Comment deleteComment(Integer id);

}
