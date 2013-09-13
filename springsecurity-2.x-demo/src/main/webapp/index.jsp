<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title></title>
</head>
<body>
<div>username : <sec:authentication property="name"/></div>
<hr>
<a href="admin.jsp">admin.jsp</a>
<a href="j_spring_security_logout">logout</a></body>
</html>