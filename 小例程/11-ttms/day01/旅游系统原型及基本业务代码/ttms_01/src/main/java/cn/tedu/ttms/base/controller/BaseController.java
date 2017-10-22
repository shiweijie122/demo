package cn.tedu.ttms.base.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import cn.tedu.ttms.user.entity.User;


public class BaseController {
	
	/**
	 * 取得session
	 * @param request
	 * @param key
	 * @return
	 */
    public Object getSession(HttpServletRequest request,String key) {
        return request.getSession().getAttribute(key);
    }

    /**
     * 设置session
     * @param request
     * @param key
     * @param value
     */
    public void setSession(HttpServletRequest request,String key, Object value) {
    	request.getSession().setAttribute(key, value);
    }

    /**
     * 移除session
     * @param request
     * @param key
     */
    public void removeSession(HttpServletRequest request,String key) {
    	HttpSession session = request.getSession();
    	if(null != session.getAttribute(key)){
    		session.removeAttribute(key);
    	}
    }
    
    public User getCurrentUser(HttpSession session){
    	return (User)session.getAttribute("currentUser");
    }
    
    /**
     * 取得配置文件信息
     * @param propName
     * @return
     */
	protected Properties getPropertiesInfo(String propName) {
		InputStream is = null;
		Properties p = new Properties();
		is = this.getClass().getResourceAsStream(propName);
		try {
			p.load(is);
			is.close();
		    return p;
		} catch (IOException e) {
			return null;
		}
	}
	

}
