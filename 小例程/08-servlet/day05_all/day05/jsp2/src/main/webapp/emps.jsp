<%@page pageEncoding="utf-8"
 import="java.util.*,entity.*"%>
<!doctype html>
<html>
	<head>
		<meta charset="utf-8">
		<title>查询员工</title>
		<style>
			table {
				border: 1px solid red;
				border-collapse: collapse;
				width: 300px;
			}
			td {
				border: 1px solid red;
				text-align: center;
			}
		</style>
	</head>
	<body>
		<%
			List<Emp> list = (List<Emp>)
				request.getAttribute("emps");
		%>
		<table>
			<tr>
				<td>编号</td>
				<td>姓名</td>
				<td>职位</td>
				<td>工资</td>
			</tr>
			<%
				for(Emp e : list) {
			%>
				<tr>
					<td><%=e.getEmpno() %></td>
					<td><%=e.getEname() %></td>
					<td><%=e.getJob() %></td>
					<td><%=e.getSal() %></td>
				</tr>
			<%		
				}
			%>
		</table>
	</body>
</html>
 
 
 
 
 