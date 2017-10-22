package cn.tedu.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.tedu.entity.User;
import cn.tedu.service.UserService;

@Controller
@Scope("prototype")
public class UserAction {
	
	@Resource
	private UserService userService;
	
	private List<User> list;
	public List<User> getList() {
		return list;
	}
	public void setList(List<User> list) {
		this.list = list;
	}
	public String list(){
		list=userService.list();
		return "list";
	}
}








