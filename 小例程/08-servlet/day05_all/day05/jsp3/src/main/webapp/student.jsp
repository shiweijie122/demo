<%@page pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="/lhh-tags" prefix="s"%>
<!doctype html>
<html>
	<head>
		<meta charset="utf-8">
		<title>查询学生</title>
	</head>
	<body>
		<h1>JSTL</h1>
		<!-- 1.if -->
		<p>
			性别:
			<c:if test="${stu.sex=='M' }">男</c:if>
			<c:if test="${stu.sex=='F' }">女</c:if>
		</p>
		<!-- 2.choose -->
		<p>
			性别:
			<c:choose>
				<c:when test="${stu.sex=='M' }">男</c:when>
				<c:otherwise>女</c:otherwise>
			</c:choose>
		</p>
		<!-- 3.forEach -->
		<p>
			<c:forEach items="${stu.interests }" var="i">
				${i }
			</c:forEach>
		</p>
		<!-- 4.自定义标签 -->
		<p>
			<s:sysdate format="yyyy年MM月dd日"/>
		</p>
	
		<h1>EL</h1>
		<!-- 1.访问Bean的属性 -->
		<!-- request.getAttribute("stu").getName() -->
		<p>姓名:${stu.name }</p>
		<p>年龄:${stu["age"] }</p>
		<!-- request.getAttribute("stu")
				.getCourse().getId() -->
		<p>课程:${stu.course.id }</p>
		<!-- 
			EL默认从如下4个隐含对象中依次取值:
			page -> request -> session -> application
			也可以明确指定取值范围:
			requestScope.stu.sex
		 -->
		<p>性别:${requestScope.stu.sex }</p>
		<!-- 2.支持运算 -->
		<p>年龄+5:${stu.age+5 }</p>
		<p>介于20-30间:${stu.age>20 && stu.age<30 }</p>
		<p>判空:${empty stu.interests }</p>
		<!-- 3.获取请求参数 -->
		<!-- request.getParameter("user") -->
		<p>参数:${param.user }</p>
	</body>
</html>










