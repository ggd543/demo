<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="mycompany.model.User" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>首页</title>
</head>
<body>
<%
    User user = (User) request.getAttribute("user");
%>
<h2>欢迎 <%= user.getName() %>
</h2>

<div><span>你的工资是：<%= user.getSalary() %>元。</span></div>
<div>
    <sec:authorize access="hasRole('ROLE_MANAGER')">
        <a href="salary.do">查看员工工资</a>
    </sec:authorize>
</div>
<div>
    <a href="report.do">查看公司报表</a>
</div>
<hr>
<div><a href="j_spring_security_logout">注销</a></div>
</body>
</html>