package cn.tedu.ttms.user.controller;


import java.util.List;


import javax.annotation.Resource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.ttms.base.controller.BaseController;
import cn.tedu.ttms.sys.utils.Constant;
import cn.tedu.ttms.sys.utils.DataOptUtil;
import cn.tedu.ttms.sys.utils.HashUtil;
import cn.tedu.ttms.user.service.UserMenuService;
import cn.tedu.ttms.user.service.UserService;
import cn.tedu.ttms.user.entity.ContactInfo;
import cn.tedu.ttms.user.entity.Menu;
import cn.tedu.ttms.user.entity.User;
import cn.tedu.ttms.user.entity.UserMenu;
/**
 * 用户登录/注册/找回密码
 */
@Controller
@RequestMapping("/userLogin")
public class LoginController extends BaseController{

	@Resource
	private UserService userService;
	@Resource
	private UserMenuService userMenuService;
	
	/**
	 * 取得联系方式
	 * @param model
	 * @param contactInfo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("getContactInfo")
	@ResponseBody
	public List<ContactInfo> selectContactInfo(Model model, ContactInfo contactInfo) throws Exception {
		List<ContactInfo> contactLst = userService.selectContactInfo(contactInfo);
		return contactLst;
	}
	
	/**
	 * 显示注册页面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("register")
	public String register() throws Exception {
		return "register";
	}
	
	/**
	 *  保存注册信息
	 * @param request
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("saveRegister")
	public String saveUser(HttpServletRequest request,User user) throws Exception {
		String hashPassword = HashUtil.hashMD5Base64(user.getPassword());
		user.setPassword(hashPassword);
		userService.addUser(user);
		removeSession(request, Constant.SESSION_KEY_VERIFYCODE);
		return "redirect:login.do";
	}
	
	/**
	 * 显示登录页面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("login")
	public String login(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		//清空session对象中的值
		session.invalidate();
		return "login";
	}
	
	/**
	 * 登录
	 * @param request
	 * @param user
	 * @return
	 */
	@RequestMapping("toLogin")
	public String toLogin(HttpServletRequest request, User user) throws Exception{
		String hashPassword = DataOptUtil.isNull(user.getPassword())?"":HashUtil.hashMD5Base64(user.getPassword());
		user.setPassword(hashPassword);
		//取得用户信息
		List<User> userLst = userService.selectUser(user, null);
		user = null==userLst || 0==userLst.size()?null:userLst.get(0);
		if(user!=null){
			ContactInfo contactInfo = new ContactInfo();
			contactInfo.setUserName(user.getUserName());
			super.setSession(request, Constant.SESSION_KEY_LOGINUSER, user);
		}

		return "redirect:index.do";
	}
	
	/**
	 * 登陆后首页
	 * @return
	 */
	@RequestMapping("index")
	
	public String index() {
		return "index";
	}
	
	@RequestMapping("getUserMenu")
	@ResponseBody
	public List<UserMenu> getUserMenu(String parentId,String level,String userId) throws Exception
	{
		List<UserMenu> menu = userMenuService.getUserMenu(parentId, level, userId);
		return menu;
	}
	/**
	 *  取得登录用户的权限菜单
	 * @param request
	 * @return
	 */
	@RequestMapping("selectMenuByUser")
	@ResponseBody
	public List<Menu> selectMenuByUser(HttpServletRequest request) throws Exception {
		User user = (User)super.getSession(request, Constant.SESSION_KEY_LOGINUSER);
		return userService.selectMenuByUser(user.getUserName());
	}
	
	
	/**
	 * 验证用户是否存在
	 * @param userName
	 * @param password
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("isExistUser")
	@ResponseBody
	public String isExistUser(String userName, String password) throws Exception{
		User user = new User();
		user.setUserName(userName);
		String hashPassword = DataOptUtil.isNull(password)?null:HashUtil.hashMD5Base64(password);
		user.setPassword(hashPassword);
		List<User> userLst = userService.selectUser(user, null);
		if(null==userLst || 0==userLst.size()) {
			return "1";
		}
		return "0";
	}
	
	
	/*====找回密码======*/
	/**
	 * 找回密码--用户确认
	 * @return
	 */
	@RequestMapping("confirmAccount")
	public String confirmAccount(){
		return "findPwd/confirmAccount";
	}
	
	/**
	 * 找回密码--选择找回方式
	 * @param userName
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("forgotPwdEmail")
	public String forgotPwdEmail(String userName,Model model) throws Exception{
		ContactInfo contactInfo = new ContactInfo();
		contactInfo.setUserName(userName);
		contactInfo.setContactType(Constant.CONTACT_TYPE_EMAIL);
		List<ContactInfo> contactLst = userService.selectContactInfo(contactInfo);
		model.addAttribute("userName", userName);
		model.addAttribute("contactLst",contactLst);
		return "findPwd/forgotPwdEmail";
	}
	
	/**
	 * 找回密码--发送邮件
	 * @param userName
	 * @param email
	 * @return
	 * @throws Exception
	 */
//	@RequestMapping("sendMail")
//	public String sendMail(String userName, String email) throws Exception{
//		Properties prop = getPropertiesInfo("/email.properties");
//		if(prop != null){
//			String smtp = prop.getProperty("smtp");
//			String sendEmail = prop.getProperty("email");
//			String pwd = prop.getProperty("password");
//			if(DataOptUtil.isNotNull(smtp) && DataOptUtil.isNotNull(sendEmail) && DataOptUtil.isNotNull(pwd)){
//				MailSender mailSender = new MailSender(smtp, sendEmail, pwd);
//				SimpleMail mail = new SimpleMail();
//				String url = "http://localhost:8080/tpms/setNewPwd.do?userName="+userName;
//				mail.setSubject("找回密码");
//				mail.setContent("请点击下方链接继续完成找回密码操作！<br/><a href='"+url+"' target='_blank'>" + url+"</a>");
//				mailSender.send(email, mail);
//				
//				return "findPwd/sendMailSuccess";
//			}
//		} 
//		
//		return "redirect:forgotPwdEmail.do?userName=" + userName;
//	}
//	
	/**
	 * 找回密码--重置密码
	 * @param userName
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("setNewPwd")
	public String setNewPwd(String userName,Model model) throws Exception{
		model.addAttribute("userName", userName);
		return "findPwd/setNewPwd";
	}
	
	/**
	 * 找回密码--保存新密码
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("saveNewPwd")
	public String saveNewPwd(User user) throws Exception{
		user.setPassword(HashUtil.hashMD5Base64(user.getPassword()));
		userService.updateUser(user);
		return "findPwd/setPwdSuccess";
	}

	/**
	 * 注销
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("toLogout")
	public String toLogout(HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:login.do";
	}
}