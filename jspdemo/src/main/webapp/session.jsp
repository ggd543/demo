<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 13-9-12
  Time: 上午9:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<html>
<head>
    <title></title>
</head>
<body>
<%
    HttpSession session = request.getSession(true);
    out.println("session: " + session + "\n");
%>
</body>
</html>