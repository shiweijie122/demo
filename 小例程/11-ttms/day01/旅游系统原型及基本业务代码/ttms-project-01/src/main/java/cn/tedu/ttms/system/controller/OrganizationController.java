package cn.tedu.ttms.system.controller;

import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.tedu.ttms.system.entity.Organization;
import cn.tedu.ttms.system.service.OrganizationService;
import cn.tedu.ttms.util.JsonResult;
import cn.tedu.ttms.util.PageObject;

@Controller
@RequestMapping("/org")
public class OrganizationController {

	@Resource
	private OrganizationService organizationService;
	@RequestMapping("/editUI")
	public String editUI() {
		return "system/organization_edit";
	}
	@RequestMapping("/listUI")
	public String listUI() {
		return "system/organization_list";
	}
	@RequestMapping("/findObjects")
	@ResponseBody
	public JsonResult doFindObjects(Organization entity,PageObject pageObject) {
		Map<String,Object> map=organizationService.findObjects(entity, pageObject);
		return new JsonResult(map);
	}
	
	@RequestMapping("/save")
	@ResponseBody
	public JsonResult doSaveObject(Organization entity) {
		organizationService.saveObject(entity);
		return new JsonResult();
	}
	@RequestMapping("/update")
	@ResponseBody
	public JsonResult doUpdateObject(Organization entity) {
		organizationService.updateObject(entity);
		return new JsonResult();
	}
	
	@RequestMapping("/findById")
	@ResponseBody
	public JsonResult doFindObjectById(Integer id) {
	    Map<String,Object> map=organizationService.findObjectById(id);
	    System.out.println("map="+map);
	    return new JsonResult(map);
	}
	
	@RequestMapping("/doValidById")
	@ResponseBody
	public JsonResult doValidById(String checkedIds,Integer valid){
		organizationService.validById(checkedIds,valid);
		return new JsonResult();
	}
}
