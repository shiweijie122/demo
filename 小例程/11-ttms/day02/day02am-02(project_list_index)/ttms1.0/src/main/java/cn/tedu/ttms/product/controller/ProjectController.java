package cn.tedu.ttms.product.controller;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.tedu.ttms.product.entity.Project;
import cn.tedu.ttms.product.service.ProjectService;
@RequestMapping("/project/")
@Controller
public class ProjectController {
	@Resource
    private ProjectService projectService;
	//http://localhost:8080/ttms1.0/project/listUI.do
	
	@RequestMapping("listUI")
	public String listUI(){
		//此字符串返回时会交给spring视图解析器
		return "product/project_list";//WEB-INF/pages/product/project_list.jsp
	}
	
    //http://localhost:8080/ttms1.0/project/doFindObjects.do
	@RequestMapping("doFindObjects")
	@ResponseBody //用于将返回的对象转换为json串
	public List<Project> doFindObjects(){
		System.out.println("==doFindObjects()==");
		return projectService.findObjects();
	}//JSON string
	//[{"id":1,"name":"aaaa",...},....]
	
	
}
