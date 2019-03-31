package com.assignment.notice.service;

import java.util.List;

import com.assignment.notice.model.dto.PostDTO;

public interface PostService {
	
	public List<PostDTO> postList(int startPostNo, int endPostNo);
	
	public PostDTO getPost(int postNo);
	
	public int insertPost(PostDTO post);
	
	public int updatePost(PostDTO post);
	
	public int deletePost(int postNo);
	
	public void increaseCount(int postNo);
	
	public int getAllCount();
}
