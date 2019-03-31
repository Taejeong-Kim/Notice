package com.assignment.notice.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.assignment.notice.model.dao.PostDAO;
import com.assignment.notice.model.dto.PostDTO;

@Service
public class PostServiceImpl implements PostService {

	@Inject
	PostDAO postDao;
	
	@Override
	public List<PostDTO> postList(int startPostNo, int endPostNo) {
		Map<String, Object> map = new HashMap<>();
		map.put("start", startPostNo);
		map.put("end", endPostNo);
		return postDao.postList(map);
	}

	@Override
	public PostDTO getPost(int postNo) {
		return postDao.getPost(postNo);
	}

	@Override
	public int insertPost(PostDTO post) {
		return postDao.insertPost(post);
	}

	@Override
	public int updatePost(PostDTO post) {
		return postDao.updatePost(post);
	}

	@Override
	public int deletePost(int postNo) {
		return postDao.deletePost(postNo);
	}

	@Override
	public void increaseCount(int postNo) {
		postDao.increaseCount(postNo);
	}

	@Override
	public int getAllCount() {
		return postDao.getAllCount();
	}

}
