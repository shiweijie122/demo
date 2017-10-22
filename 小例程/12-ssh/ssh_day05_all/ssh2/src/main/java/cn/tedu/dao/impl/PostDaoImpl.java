package cn.tedu.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cn.tedu.dao.PostDao;
import cn.tedu.entity.Post;

@Repository("postDao")
@Transactional
public class PostDaoImpl implements PostDao {
	
	@Resource
	private HibernateTemplate hibernateTemplate;
	
	public List<Post> findAll() {
		String hql = "from Post";
		List<Post> list= (List<Post>)
				hibernateTemplate.find(hql);
		return list;
	}

}






