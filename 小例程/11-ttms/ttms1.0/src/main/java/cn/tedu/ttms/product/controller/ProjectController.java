package cn.tedu.ttms.product.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.ttms.common.web.JsonResult;
import cn.tedu.ttms.product.entity.Project;
import cn.tedu.ttms.product.service.ProjectService;

@Controller
@RequestMapping("/project")
public class ProjectController {

	@Resource
	private ProjectService projectService;
	
	@RequestMapping("/listUI")
	public String listUI(){
		//此字符串返回时会交给spring视图解析器
		return "product/project_list";
	}
	
	@RequestMapping("/doFindObjects")
	@ResponseBody
	public JsonResult doFindObjects(){
		System.out.println("====doFindObjects====");
		List<Project> list = projectService.findObjects();
		//将获得的数据封装到JsonResult对象
		return  new JsonResult(list);
	}
}
