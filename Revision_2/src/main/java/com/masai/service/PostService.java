package com.masai.service;

import java.util.List;

import com.masai.model.Post;

public interface PostService {
	
	public Post registerPost(Post post);
	
	public Post updatePost(Post post);
	
	public Post deletePost(Integer id);
	
	public Post getPostById(Integer id);
	
	public List<Post> getAllPosts();

}
