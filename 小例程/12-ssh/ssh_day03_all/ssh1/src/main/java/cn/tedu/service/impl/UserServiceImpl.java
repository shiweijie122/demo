package cn.tedu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tedu.dao.UserDao;
import cn.tedu.entity.User;
import cn.tedu.service.UserService;

@Service("userService")
public class UserServiceImpl 
	implements UserService{

	@Resource
	private UserDao userDao;
	
	@Transactional
	public List<User> list() {
		return userDao.findAll();
	}
}




