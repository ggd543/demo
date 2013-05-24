<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="mycompany.model.User,java.util.List" %>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工工资</title>
</head>
<body>
<h4>员工信息</h4>
<div>
	<table border="1">
		<thead>
			<th>姓名</th>
			<th>工资（元）</th>
		</thead>
		<tbody>
			<% List<User> users = (List<User>) request.getAttribute("users"); %>
			<%
				for (int i = 0, n = users.size(); i < n; i++) {
					User user = users.get(i);
			%>
			<tr>
				<td><%= user.getName() %></td>
				<td><%= user.getSalary() %></td>
			</tr>
			<%
				}
			%>	
		</tbody>
	</table>
</div>
<div>
	<div>给员工加薪：</div>
	<div>
		<form method="POST" action="salary.do">
		<span>选择员工：</span>
		<select name="employee">
			<%
				for (int i = 0, n = users.size(); i < n; i++) {
					User user = users.get(i);
			%>
				<option value="<%= user.getUsername() %>"><%= user.getName() %></option>
			<%
				}
			%>
		</select>
		<input value="加薪" type="submit">
		</form>
	</div>
</div>
<hr>
<div><a href="index.do">返回首页</a></div>
<div><a href="j_spring_security_logout">注销</a></div>
</body>
</html>