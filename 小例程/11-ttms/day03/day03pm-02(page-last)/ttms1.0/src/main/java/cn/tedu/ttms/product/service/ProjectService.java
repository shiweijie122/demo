package cn.tedu.ttms.product.service;

import java.util.Map;

/**
 * 项目管理模块的业务层对象:
 * 负责具体项目信息的业务处理
 */
public interface ProjectService {
	 /**获得当前页项目信息以及分页信息
	  * 1)项目信息封装到List<Project>
	  * 2)分页信息封装到PageObject
	  * 将项目信息和分页信息再次封装,
	  * 封装map,然后做统一返回
	  * */
     Map<String,Object> findObjects(
    		 int pageCurrent); 
     //......
}






