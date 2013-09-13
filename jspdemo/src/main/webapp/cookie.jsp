<%@ page import="java.util.Date" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 13-9-12
  Time: 上午9:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="" %>
<html>
<head>
    <title></title>
</head>
<body>

size of cookies : <%= request.getCookies().length %>
<%! int nextId = 0; %>
<br/>
<%
    Cookie newCookie = new Cookie("" + (nextId++), new Date().toString());
    response.addCookie(newCookie);
    for (Cookie cookie : request.getCookies()) {
        out.println("Name: " + cookie.getName() + " value: " + cookie.getValue()
                + " domain: " + cookie.getDomain() + " path: " + cookie.getPath()+"\n");
    }
%>
</body>
</html>