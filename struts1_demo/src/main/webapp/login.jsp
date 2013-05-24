<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>

<html>
<head>
    <title>JSP for LoginForm form</title>
</head>
<body>
<%--<form action="${pageContext.request.contextPath }/login.do?method=submit" method="post">--%>
<%--用户名：--%>
<%--<input name="username" type="text" />--%>
<%--密码：--%>
<%--<input name="password" type="password" />--%>
<%--<input type="submit" value="登录" />--%>
<%--</form>--%>
<html:form action="/login.do" method="POST">
    <bean:message key="form.message"/><br/>
    <bean:message key="form.username"/> <html:text property="username"/><br/>
    <bean:message key="form.password"/><html:password property="password"/><br/>
    <html:submit value="method1" property="method" ><bean:message key="form.submit1"/></html:submit><br/>
    <html:submit value="method2" property="method" ><bean:message key="form.submit2"/></html:submit><br/>
    <html:reset><bean:message key="form.reset"/></html:reset> <br/>
</html:form>
<html:errors property="error.hint"/>
</body>
</html>

