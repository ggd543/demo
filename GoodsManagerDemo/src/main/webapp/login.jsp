<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body style="FONT-SIZE: 14px;	COLOR: #003366;	FONT-FAMILY: 微软雅黑;">
<center>
    <h1>请输入授权码</h1>
    <form action="login.do">
        <input type="text" name="authcode" style="width:600px;"><input type="submit" value="提交授权码">
    </form>
    <br>

    <%
        String url = "http://open.taobao.com/isv/authorize.php?appkey=" + request.getAttribute("appKey");
    %>
    <iframe frameborder="0" height="500px" width="1200px" src="<%=url%>">

    </iframe>
</center>
</body>
</html>