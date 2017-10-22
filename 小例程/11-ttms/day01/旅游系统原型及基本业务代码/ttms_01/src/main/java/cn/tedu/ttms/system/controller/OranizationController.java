package cn.tedu.ttms.system.controller;

import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.ttms.base.controller.JsonBaseController;
import cn.tedu.ttms.base.entity.PageObject;
import cn.tedu.ttms.system.entity.Organization;
import cn.tedu.ttms.system.service.OrganizationService;
import cn.tedu.ttms.base.entity.JsonResult;

@Controller
@RequestMapping("/org")
public class OranizationController extends JsonBaseController {
	@Resource
	private OrganizationService orgService;

	/**
	 * 查询 项目信息
	 * @param model
	 * @param projectInfo
	 * @param pageObj
	 * @throws Exception
	 */
	@RequestMapping("/findObjects.do")
	@ResponseBody
	public JsonResult<Map<String, Object>> organizationList(Organization orgInfo, PageObject pageObj) throws Exception {
		return new JsonResult<Map<String, Object>>(orgService.findObjects(orgInfo, pageObj));
	}

	/** 点击页面菜单中的项目管理 */
	@RequestMapping("/manageUI.do")
	public String manageUI() {
		return "ttms/system/organization_list";
	}

	/**
	 *修改页面
	 * @return
	 */
	@RequestMapping("/addUI.do")
	public String addUI() {
		return "ttms/system/organization_add";
	}
	
	/**
	 *修改页面
	 * @return
	 */
	@RequestMapping("/editUI.do")
	public String updateUI() {
		return "ttms/system/organization_edit";
	}

	/**
	 * 编辑保存 项目信息
	 * 
	 * @param projectInfo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/save.do")
	@ResponseBody
	public JsonResult<Object> organizationSave(Organization info, HttpSession session) throws Exception {
		String user = getCurrentUser(session).getUserName();
		info.setCreatedUser(user);
		orgService.saveObject(info);
		return new JsonResult<Object>();
	}
	/**
	 * 编辑保存组织结构信息
	 * 
	 * @param projectInfo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/update.do")
	@ResponseBody
	public JsonResult<Object> organizationUpdate(Organization info, HttpSession session) throws Exception {
		String user = getCurrentUser(session).getUserName();
		info.setCreatedUser(user);
		orgService.updateObject(info);
		return new JsonResult<Object>();
	}
	/***
	 * 根据id查找项目信息，然后将项目信息封装到jsonResult对象中
	 * @param prjId
	 * @return
	 */
	@RequestMapping("/findById.do")
	@ResponseBody
	public JsonResult<Map<String, Object>> findById(String id) {
		Map<String, Object> map = orgService.findById(id);
		return new JsonResult<Map<String, Object>>(map);
	}
	/**
	 * 启用 禁用
	 * @param id
	 * @param valid
	 * @param updateUser
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/validById.do")
	@ResponseBody
	public JsonResult<Object> validById(Integer id, Integer valid, HttpSession session) throws Exception {
		String user = getCurrentUser(session).getUserName();
		orgService.validById(id, valid, user);
		return new JsonResult<Object>();
	}

}
