package cn.tedu.netctoss.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.netctoss.dao.AdminDAO;
import cn.tedu.netctoss.entity.Admin;
/**
 * 业务层实现类
 *
 */
@Service("loginService")
public class LoginServiceImpl implements 
LoginService{
	
	@Resource(name="adminDAO")
	private AdminDAO dao;

	public Admin checkLogin(
			String code, String pwd) {
		Admin admin = null;
		admin = dao.findByCode(code);
		if(admin == null){
			/*
			 *  抛出一个应用异常。
			 *  注：
			 *  	应用异常，指的是由于用户
			 *  错误的操作引起的异常，比如
			 *  帐号错误。对于应用异常，应该
			 *  明确提示用户采取正确的操作。
			 */
			throw new AppException("帐号错误");
		}
		if(!admin.getPassword().equals(pwd)){
			throw new AppException("密码错误");
		}
		//登录通过
		return admin;
	}
	
	

}
