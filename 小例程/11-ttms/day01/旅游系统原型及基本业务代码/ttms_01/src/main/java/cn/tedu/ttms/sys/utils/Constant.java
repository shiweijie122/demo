package cn.tedu.ttms.sys.utils;

import javax.servlet.http.HttpSession;

import cn.tedu.ttms.user.entity.User;



public class Constant {

	/**
	 * 当前登陆用户KEY值
	 */
	public final static String SESSION_KEY_LOGINUSER = "currentUser";
	
	public static User currentUser(HttpSession session){
		User user = (User) session.getAttribute(Constant.SESSION_KEY_LOGINUSER);
		return user;
	}

	/**
	 * 验证码KEY值
	 */
	public final static String SESSION_KEY_VERIFYCODE = "verifyCode";

	/**
	 * 验证码图片大小
	 */
	public final static int VERIFY_IMAGE_W = 120;
	public final static int VERIFY_IMAGE_H = 50;

	/**
	 * 验证码位数
	 */
	public final static int VERIFY_SIZE = 4;

	/**
	 * MD5加密
	 */
	public final static String KEY_MD5 = "MD5";

	/**
	 * 初始密码
	 */
	public final static String INITIAL_PWD = "666666";

	/**
	 * 联系方式类别（1:电话 2:邮箱）
	 */
	public final static String CONTACT_TYPE = "001";
	public final static String CONTACT_TYPE_PHONE = "1"; // 电话
	public final static String CONTACT_TYPE_EMAIL = "2"; // 邮箱

	/**
	 * 性别（f:女 m:男）
	 */
	public final static String SEX_MALE = "m"; // 男

	/**
	 * 操作类型
	 */
	// public final static int OPT_DEFAULT = 0x00;//默认
	public final static int OPT_ADD = 0x01; // 添加
	public final static int OPT_EDIT = 0x02; // 修改
	// public final static int OPT_DELETE = 0x03;//删除
	
	/**
	 * 密码加密的盐
	 */
	public final static String SALT = "Powerd By TEDU.CN";
}
