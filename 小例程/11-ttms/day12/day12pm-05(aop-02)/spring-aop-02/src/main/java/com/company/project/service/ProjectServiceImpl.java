package com.company.project.service;

import org.springframework.stereotype.Service;
/**
 * 需求:为此业务类中的方法植入一些日志操作
 * 1)方法执行之前输出method.start
 * 2)方法执行之后输出method.end
 * */
@Service
public class ProjectServiceImpl implements ProjectService {
	public void saveObject(Object obj) {
		System.out.println("project.save");
	}
	public void updateObject(Object obj) {
		System.out.println("project.update");
		if(obj==null)
		throw new RuntimeException("obj==null");
	}
}
