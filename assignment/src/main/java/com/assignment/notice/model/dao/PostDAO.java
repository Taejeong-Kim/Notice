package com.assignment.notice.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.assignment.notice.model.dto.PostDTO;

@Mapper
public interface PostDAO {
	
	public List<PostDTO> postList(Map<String, Object> map);
	
	public PostDTO getPost(int postNo);
	
	public int insertPost(PostDTO post);
	
	public int updatePost(PostDTO post);
	
	public int deletePost(int postNo);
	
	public void increaseCount(int postNo);
	
	public int getAllCount();
}
