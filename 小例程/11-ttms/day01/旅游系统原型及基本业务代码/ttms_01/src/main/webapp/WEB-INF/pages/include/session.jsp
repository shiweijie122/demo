<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="cn.tedu.ttms.user.entity.User,cn.tedu.ttms.sys.utils.Constant"%>
<%
	User user = (User) session.getAttribute(Constant.SESSION_KEY_LOGINUSER);
	String currentUser = user.getName();
	String currentUserName = user.getUserName();
	String userName = user.getName();

	//相对路径
	String contextPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath();
	if (contextPath.endsWith("/")) {
		contextPath = contextPath.substring(0, contextPath.length() - 1);
	}
%>