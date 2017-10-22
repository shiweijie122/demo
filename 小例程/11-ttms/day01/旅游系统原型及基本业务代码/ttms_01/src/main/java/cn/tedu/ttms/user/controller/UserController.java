package cn.tedu.ttms.user.controller;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.ttms.base.controller.BaseController;
import cn.tedu.ttms.base.entity.PageObject;
import cn.tedu.ttms.sys.entity.Dictionary;
import cn.tedu.ttms.sys.entity.UserGroup;
import cn.tedu.ttms.sys.service.DictionaryService;
import cn.tedu.ttms.sys.service.UserGroupService;
import cn.tedu.ttms.sys.utils.Constant;
import cn.tedu.ttms.sys.utils.DataOptUtil;
import cn.tedu.ttms.sys.utils.HashUtil;
import cn.tedu.ttms.user.entity.Role;
import cn.tedu.ttms.user.entity.User;
import cn.tedu.ttms.user.entity.UserRole;
import cn.tedu.ttms.user.service.RoleService;
import cn.tedu.ttms.user.service.UserService;



/*
 * 用户管理
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController{

	@Resource
	private UserService userService;
	@Resource
	private RoleService roleService;
	@Resource
	private DictionaryService dictService;
	@Resource
	private UserGroupService userGroupService;
	
	/**
	 * 查询用户信息
	 * @param model
	 * @param user
	 * @param pageObj
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public String selectUser(Model model, User user, PageObject pageObj) throws Exception {
		List<User> userLst = userService.selectUserList(user, pageObj);
		List<User> selectTypeLst = userService.selectUserType(null, null);
		List<User> selectClassLst = userService.selectUserClass(null, null);
		for(User user1 : userLst){
		String userId=user1.getUserId();
		//获取权限角色
		List<User> roleNames=userService.selectUserRoleName(userId);
		StringBuffer roleNameList=new StringBuffer();
		//将权限角色放入User(拼接字符串)
		for(int j=0;j<=roleNames.size()-1;j++){
		String roleName=roleNames.get(j).getRoleName();
			if(j!=roleNames.size()-1){
				roleNameList.append("").append(roleName).append(",");
			}else{
				roleNameList.append("").append(roleName);
			}						
		}
		if(roleNameList!=null){
			user1.setRoleName(roleNameList.toString());
		}
		String orgIds=user1.getOrgIds();
		String grpIds=user1.getGrpIds();
		if(orgIds!=null&&orgIds.length()!=0){
		if(orgIds.indexOf(";")>0){
		String[] orgId=orgIds.split(";");
		StringBuffer orgNames=new StringBuffer();
		for(int k=0;k<=orgId.length-1;k++){
			String orgName  = userService.selectUserOrgName(orgId[k]);
			if(orgName!=null && orgName !=""){
				if(k!=orgId.length-1){
					orgNames.append(" ").append(orgName).append(",");
				}else{
					orgNames.append(" ").append(orgName);
				}				
			}
		}
		user1.setOrgIds(orgNames.toString());
		}else{
			String orgName  = userService.selectUserOrgName(orgIds);
			user1.setOrgIds(orgName);
		}
		}
		if(grpIds!=null&&grpIds.length()!=0){
		if(grpIds.indexOf(";")>0){
			String[] grpId=grpIds.split(";");
			StringBuffer grpNames=new StringBuffer();
			for(int k=0;k<=grpId.length-1;k++){
				String grpName  = userService.selectUserGrpName(grpId[k]);
				if(grpName!=null && grpName !=""){
					if(k!=grpId.length-1){
						grpNames.append(" ").append(grpName).append(",");
					}else{
						grpNames.append(" ").append(grpName);
					}					
				}
				}
			user1.setGrpIds(grpNames.toString());
			}else{
				String grpName  = userService.selectUserGrpName(grpIds);
				user1.setGrpIds(grpName);
			}
		}
		
		Date regDate=user1.getRegDate();
		if(regDate!=null){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	    user1.setRegDate(dateFormat.parse(dateFormat.format(regDate)));
	    }
		}		
		if(pageObj == null) {
			pageObj = new PageObject();
		}
		pageObj.setStartIndex(pageObj.getStartIndex());
		pageObj.setRowCount(userService.GetRecordCount(user));
		model.addAttribute("userLst", userLst);
		model.addAttribute("pageObject",pageObj);
		model.addAttribute("selectTypeLst",selectTypeLst);
		model.addAttribute("selectClassLst",selectClassLst);
		model.addAttribute("user", user);
		return "user/userList";
	}
	
	/**
	 * 查询用户信息
	 * @param model
	 * @param user
	 * @param pageObj
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("infoList")
	public String userInfoList(Model model, User user, PageObject pageObj,String userIds) throws Exception {
		user.setUserId(userIds);
		List<User> userLst = userService.selectUserList(user, pageObj);
		for(User user1 : userLst){
		String userId=user1.getUserId();
		//获取权限角色
		List<User> roleNames=userService.selectUserRoleName(userId);
		StringBuffer roleNameList=new StringBuffer();
		//将权限角色放入User(拼接字符串)
		for(int j=0;j<=roleNames.size()-1;j++){
		String roleName=roleNames.get(j).getRoleName();
			if(j!=roleNames.size()-1){
				roleNameList.append("").append(roleName).append(",");
			}else{
				roleNameList.append("").append(roleName);
			}						
		}
		if(roleNameList!=null){
			user1.setRoleName(roleNameList.toString());
		}
		String orgIds=user1.getOrgIds();
		String grpIds=user1.getGrpIds();
		if(orgIds!=null&&orgIds.length()!=0){
		if(orgIds.indexOf(";")>0){
		String[] orgId=orgIds.split(";");
		StringBuffer orgNames=new StringBuffer();
		for(int k=0;k<=orgId.length-1;k++){
			String orgName  = userService.selectUserOrgName(orgId[k]);
			if(orgName!=null && orgName !=""){
				if(k!=orgId.length-1){
					orgNames.append(" ").append(orgName).append(",");
				}else{
					orgNames.append(" ").append(orgName);
				}				
			}
		}
		user1.setOrgIds(orgNames.toString());
		}else{
			String orgName  = userService.selectUserOrgName(orgIds);
			user1.setOrgIds(orgName);
		}
		}
		if(grpIds!=null&&grpIds.length()!=0){
		if(grpIds.indexOf(";")>0){
			String[] grpId=grpIds.split(";");
			StringBuffer grpNames=new StringBuffer();
			for(int k=0;k<=grpId.length-1;k++){
				String grpName  = userService.selectUserGrpName(grpId[k]);
				if(grpName!=null && grpName !=""){
					if(k!=grpId.length-1){
						grpNames.append(" ").append(grpName).append(",");
					}else{
						grpNames.append(" ").append(grpName);
					}					
				}
				}
			user1.setGrpIds(grpNames.toString());
			}else{
				String grpName  = userService.selectUserGrpName(grpIds);
				user1.setGrpIds(grpName);
			}
		}
		
		Date regDate=user1.getRegDate();
		if(regDate!=null){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	    user1.setRegDate(dateFormat.parse(dateFormat.format(regDate)));
	    }
		}		
		if(pageObj == null) {
			pageObj = new PageObject();
		}
		model.addAttribute("user", userLst.get(0));
		return "user/userInfo";
	}
	
	/**
	 * 修改密码
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("editPwd")
	public String editPwd(HttpServletRequest request,String userId,Model model) throws Exception{
		User user = (User) getSession(request, Constant.SESSION_KEY_LOGINUSER);
		model.addAttribute("user", user);
		return "user/editPwd";
	}
	
	/**
	 * 修改用户,新增用户
	 * @param request
	 * @param user
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("edit")
	public String editUser(HttpServletRequest request,User user,Model model) throws Exception{
		if(Constant.OPT_ADD == user.getOptType()) { 
			//新增
			List<User> selectTypeLst = userService.selectUserType(null, null);
			List<User> selectClassLst = userService.selectUserClass(null, null);
			List<User> selectRoleLst = userService.selectUserRole(null, null);
			List<UserGroup> supplierList=userGroupService.selectCompanies();
			//查询已拥有权限角色
			List<User> selectRoleNameLst=userService.selectUserRoleName(user.getUserId());
			List<User> selectRoleNameLstNo=new ArrayList<User>();
			for(int t=0;t<=selectRoleLst.size()-1;t++){
				String roleHave="";
				int j=0;
			User u=new User();
			String role  =	selectRoleLst.get(t).getRoleId();
				for(int k=0;k<=selectRoleNameLst.size()-1;k++){
					 roleHave=selectRoleNameLst.get(k).getRoleId();
					if(role.equals(roleHave)){
						j=2;						
					}
				}
				if(j==0){
					u.setRoleId(role);
					u.setRoleName(selectRoleLst.get(t).getRoleName());
				}
				if(u.getRoleId()!=null&&u.getRoleId()!=""){
					selectRoleNameLstNo.add(u);					
				}				
			};
			model.addAttribute("selectTypeLst",selectTypeLst);
			model.addAttribute("selectClassLst",selectClassLst);
			model.addAttribute("selectRoleLst",selectRoleLst);
			model.addAttribute("selectRoleNameLst",selectRoleNameLst);
			model.addAttribute("selectRoleNameLstNo",selectRoleNameLstNo);
			model.addAttribute("supplierList",supplierList);
			model.addAttribute("type", "add");
		} else if (Constant.OPT_EDIT == user.getOptType()) { //编辑
			List<User> selectTypeLst = userService.selectUserType(null, null);
			List<User> selectClassLst = userService.selectUserClass(null, null);
			List<User> selectRoleLst = userService.selectUserRole(null, null);
			List<UserGroup> supplierList=userGroupService.selectCompanies();
			//查询已拥有权限角色
			List<User> selectRoleNameLst=userService.selectUserRoleName(user.getUserId());
			List<User> selectRoleNameLstNo=new ArrayList<User>();
			for(int t=0;t<=selectRoleLst.size()-1;t++){
				String roleHave="";
				int j=0;
			User u=new User();
			String role  =	selectRoleLst.get(t).getRoleId();
				for(int k=0;k<=selectRoleNameLst.size()-1;k++){
					 roleHave=selectRoleNameLst.get(k).getRoleId();
					if(role.equals(roleHave)){
						j=2;						
					}
				}
				if(j==0){
					u.setRoleId(role);
					u.setRoleName(selectRoleLst.get(t).getRoleName());
				}
				if(u.getRoleId()!=null&&u.getRoleId()!=""){
					selectRoleNameLstNo.add(u);					
				}				
			};
			model.addAttribute("selectTypeLst",selectTypeLst);
			model.addAttribute("selectClassLst",selectClassLst);
			model.addAttribute("selectRoleLst",selectRoleLst);
			model.addAttribute("selectRoleNameLst",selectRoleNameLst);
			model.addAttribute("selectRoleNameLstNo",selectRoleNameLstNo);
			model.addAttribute("supplierList",supplierList);
			List<User> userList = userService.selectUserList(user, null);
			user = userList.size() > 0 ? userList.get(0): user;
			user.setRepassword(user.getPassword());
			user.setOptType(Constant.OPT_EDIT);
			model.addAttribute("user", user);			
			model.addAttribute("type", "edit");
		}
		return "user/editUser";
	}
	
	
	/**
	 * 取得联系方式类型
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("getTypeList")
	@ResponseBody
	public List<Dictionary> getTypeList() throws Exception {
		Dictionary dict = new Dictionary();
		dict.setDictTypeId(Constant.CONTACT_TYPE);
		return dictService.selectDictonary(dict);
	}
	
	/**
	 * 保存修改用户信息
	 * @param user
	 * @param contacts
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("saveUser")
	public void saveEditUser(HttpServletRequest request,User user, HttpServletResponse response) throws Exception {
		PrintWriter out = response.getWriter();
		
		if(user.getOptType()==Constant.OPT_ADD){
			String hashPassword = HashUtil.hashMD5Base64(user.getPassword());
			user.setPassword(hashPassword);
			User users = (User) getSession(request, Constant.SESSION_KEY_LOGINUSER);
			String role=user.getRoleId();
			//先删权限
			userService.delUpdateUserRole(user.getUserId());
			String[] roleIds=role.split(",");
			for(int j=0; j<=roleIds.length-1;j++){
			String id=roleIds[j];
			if(id != null && id.length() != 0){
				user.setRoleId(id);
				user.setModifiedUser(users.getUserName());
				//更改权限表
				userService.updateUserRole(user);
			}
			}
			Date regDate=new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		    user.setRegDate(dateFormat.parse(dateFormat.format(regDate)));
			int addUser = userService.addUser(user);
			if(addUser > 0){
				out.print("<script>parent.closeModal();</script>");
			}
		}else if(user.getOptType()==Constant.OPT_EDIT){
			User users = (User) getSession(request, Constant.SESSION_KEY_LOGINUSER);
			String role=user.getRoleId();
			//先删权限
			userService.delUpdateUserRole(user.getUserId());
			String[] roleIds=role.split(",");
			for(int j=0; j<=roleIds.length-1;j++){
			String id=roleIds[j];
			if(id != null && id.length() != 0){
				user.setRoleId(id);
				user.setModifiedUser(users.getUserName());
				//更改权限表
				userService.updateUserRole2(user);
			}
			}
			user.setModifiedUser(users.getUserName());
			int updateUser = userService.updateUser(user);
			if(updateUser > 0){
				out.print("<script>parent.closeModal();</script>");
			}
		}
		out.flush();
		out.close();
	}
	
	/**
	 * 修改用户启用禁用
	 * @param userName
	 * @return
	 */
	@RequestMapping("upda")
	public String updateUserValid(HttpServletRequest request,User user,String id, String valid) throws Exception{
		User users = (User) getSession(request, Constant.SESSION_KEY_LOGINUSER);
		user.setUserId(id);
		user.setValid("0".equals(valid) ? "1" : "0");
		user.setModifiedUser(users.getUserName());
		userService.updateUserValid(user);
		return "redirect:list.do";
	}
	
	//删除用户
	@RequestMapping("del")
	public String delUser(String userId) throws Exception{
		userService.deleteUser(userId);
		userService.delUpdateUserRole(userId);
		return "redirect:list.do";
	}
		
	/**
	 * 分配角色
	 * @param model
	 * @param userName
	 * @return
	 */
	@RequestMapping("assignRole")
	public String assignRole(Model model, String userName) throws Exception {
		List<Role> roleList = roleService.selectRole(null, null);
		model.addAttribute("roleList", roleList);
		model.addAttribute("userName", userName);
		return "user/assignRole";
	}
	
	/**
	 * 取得用户的权限
	 * @param userName
	 * @return
	 */
	@RequestMapping("selectRoleByUser")
	@ResponseBody
	public List<UserRole> selectRoleByUser(String userName) throws Exception {
		return userService.selectRoleByUser(userName);
	}
	
	/**
	 * 保存分配角色
	 * @param userName
	 * @param roleIds
	 * @return
	 */
	@RequestMapping("saveAssignRole")
	public String saveAssignRole(String userName, String roleIds) throws Exception {
		String[] ids = roleIds.split(",");
		List<UserRole> userRoleList = new ArrayList<UserRole>();
		for(String id:ids){
			if(DataOptUtil.isNotNull(id)){
				UserRole userRole = new UserRole();
				userRole.setUserName(userName);
				userRole.setRoleId(id);
				userRoleList.add(userRole);
			}
		}
		userService.addUserRole(userRoleList, userName);
		return "redirect:list.do";
	}
	
	/**
	 * 注销
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("logout")
	public String logout(HttpServletRequest request) throws Exception {
		super.removeSession(request, Constant.SESSION_KEY_LOGINUSER);
		return "redirect:../userLogin/login.do";
	}
	@RequestMapping("checkUserName")
	@ResponseBody
	public boolean checkUserName(HttpServletResponse response,String userName)throws Exception {
		boolean check=Boolean.TRUE;;
		if(userService.checkUserId(userName)>0){
				check= Boolean.FALSE;
		}
		return check;
	}
}