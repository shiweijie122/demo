package cn.tedu.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.tedu.entity.Post;
import cn.tedu.service.PostService;

@Controller
@Scope("prototype")
public class PostAction {
	
	@Resource 
	private PostService postService;
	
	private JsonResult result;
	public JsonResult getResult() {
		return result;
	}
	public void setResult(JsonResult result) {
		this.result = result;
	}
	
	public String list(){
		System.out.println("list"); 
		List<Post> list = postService.list();
		result = new JsonResult(list);
		return "json";
	}

}





