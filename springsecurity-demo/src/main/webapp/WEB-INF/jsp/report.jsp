<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="mycompany.model.*,java.util.List" %>       
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>公司报表</title>
</head>
<body>
<div>
	<h4>当前可查看报表</h4>
	<table border="1">
		<thead>
			<th>标题</th>
			<th>内容</th>
		</thead>
		<tbody>
			<% 
				List<Report> reports = (List<Report>) request.getAttribute("reports");  
				for (int i = 0, n = reports.size(); i < n; i++) {
					Report report = reports.get(i);
			%>
				<tr>
					<td><%= report.getTitle() %></td>
					<td><%= report.getContent() %></td>
				</tr>
			<%
				}
			%>
		</tbody>
	</table>
</div>
<div>
<sec:authorize access="hasRole('ROLE_PRESIDENT')">
	<hr>
	<h4>创建新报表</h4>
	<form method="post" action="report.do">
		<div>
		<label for="title">标题：</label><input id="title" name="title">
		</div>
		<div>
		<label for="content">内容：</label><textarea id="content" name="content" cols="40" rows="10"></textarea>
		</div>
		<input type="hidden" name="action" value="add">
		<input type="submit" value="提交">
		<input type="reset" value="重置">
	</form>
	
	<hr>
	<h4>授权查看报表</h4>
	<form method="post" action="report.do">
		<label>报表名称：</label>
		<select name="reportId">
			<%
			for (int i = 0, n = reports.size(); i < n; i++) {
				Report report = reports.get(i);
			%>
				<option value="<%= report.getId() %>"><%= report.getTitle() %></option>
			<%
			}
			%>
		</select>
		<% List<User> users = (List<User>) request.getAttribute("users"); %>
		<select name="username">
			<%
				for (int i = 0, n = users.size(); i < n; i++) {
					User user = users.get(i);
			%>
				<option value="<%= user.getUsername() %>"><%= user.getName() %></option>
			<%
				}
			%>
		</select>
		<input type="hidden" name="action" value="grant">
		<input type="submit" value="授权查看">
	</form>
</sec:authorize>
</div>
<hr>
<div><a href="index.do">返回首页</a></div>
<div><a href="j_spring_security_logout">注销</a></div>
</body>
</html>