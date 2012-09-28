<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false" %>

<html>
	<head>
		<title>JSP for LoginForm form</title>
	</head>
	<body>
		<form action="${pageContext.request.contextPath }/login.do" method="post">
			用户名：
			<input name="username" type="text" />
			密码：
			<input name="password" type="password" />
			<input type="submit" value="登录" />
		</form>
	</body>
</html>

