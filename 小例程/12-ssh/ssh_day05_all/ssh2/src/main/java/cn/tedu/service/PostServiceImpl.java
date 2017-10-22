package cn.tedu.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tedu.dao.PostDao;
import cn.tedu.entity.Post;

@Service("postService")
@Transactional
public class PostServiceImpl 
	implements PostService{

	@Resource
	private PostDao postDao;
	
	public List<Post> list() {
		return postDao.findAll();
	}
}


