package cn.tedu.ttms.product.service;

import java.util.List;

import cn.tedu.ttms.product.entity.Project;

/**
 * 项目管理模块的业务层对象:
 * 负责具体项目信息的业务处理
 */
public interface ProjectService {
	   /**获得所有项目信息*/
       List<Project> findObjects(); 
       //......
}






