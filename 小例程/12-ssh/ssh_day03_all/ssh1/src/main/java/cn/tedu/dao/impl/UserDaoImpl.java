package cn.tedu.dao.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.tedu.dao.UserDao;
import cn.tedu.entity.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
	
	@Resource
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public List<User> findAll() {
		return (List<User>)hibernateTemplate
				.find("from User");
	}
	
	@Transactional
	public void save(User user) {
		hibernateTemplate.save(user);
	}
	@Transactional
	public void delete(User user) {
		hibernateTemplate.delete(user);
	}
	@Transactional
	public void update(User user){
		hibernateTemplate.update(user); 
	}
	
	@Transactional
	public List<User> findByAddress(
			String address) {
		String hql="from User "
				+ "where address=?";
		return (List<User>)hibernateTemplate
				.find(hql, address); 
	}
}




