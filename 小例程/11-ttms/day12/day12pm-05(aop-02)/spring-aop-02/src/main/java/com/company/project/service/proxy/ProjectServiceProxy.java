package com.company.project.service.proxy;
import com.company.project.service.ProjectService;
import com.company.project.service.aspect.LogAspect;

/**
 * 创建一个代理类:ProjectServiceProxy
 * 目的:为实现了ProjectService接口的类添加
 * 日志处理操作
 */
public class ProjectServiceProxy implements ProjectService{
    /**接口引用指向被代理的对象*/
	private ProjectService projectService;
	public ProjectServiceProxy(ProjectService projectService) {
		this.projectService=projectService;
	}
	/**通过此类封装日志处理操作*/
	private LogAspect logAspect;
	public void setLogAspect(
			LogAspect logAspect) {
		this.logAspect = logAspect;
	}
	public void saveObject(Object obj) {
		//System.out.println("method.start");
		logAspect.before();
		projectService.saveObject(obj);
		logAspect.after();
		//System.out.println("method.after");
	}
	public void updateObject(Object obj) {
		//System.out.println("method.start");
		logAspect.before();
		projectService.updateObject(obj);
		logAspect.after();
		//System.out.println("method.after");
	}
}
