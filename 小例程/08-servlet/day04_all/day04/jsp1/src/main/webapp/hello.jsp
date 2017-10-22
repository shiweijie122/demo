<%@page pageEncoding="utf-8"%>
<!doctype html>
<html>
	<head>
		<meta charset="utf-8">
		<title>第一个JSP</title>
	</head>
	<body>
		<!-- 3.jsp声明:声明成员或方法. -->
		<%!
			public long bai(double n) {
				return Math.round(n*100);
			}
		%>
		<ul>
			<!-- 1.jsp脚本:完整的java代码段. -->
			<%
				for(int i=0;i<10;i++) {
			%>
				<!-- 2.jsp表达式:输出数据. -->
				<li><%=bai(Math.random()) %></li>
			<%		
				}
			%>
		</ul>
		<!-- 引入date.jsp,相当于将其
			内容复制到此处. -->
		<%@include file="date.jsp"%>
	</body>
</html>






