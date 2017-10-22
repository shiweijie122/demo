<!-- 
pageEncoding:声明文件的编码.
contentType:声明向浏览器输出的内容的格式.
import:导包.
 -->
<%@page pageEncoding="utf-8"
	contentType="text/html"
	import="java.util.*,java.text.*"%>
<%
	Date date = new Date();
	SimpleDateFormat sdf = 
		new SimpleDateFormat("yyyy/MM/dd");
	String today = sdf.format(date);
%>
<p><%=today %></p>







