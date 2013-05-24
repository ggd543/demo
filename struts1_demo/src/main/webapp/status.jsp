<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 13-3-18
  Time: 下午5:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>

<html>
<head>
    <title></title>
</head>
<body>
<html:form action="/status">
    <html:submit property="method">
        <bean:message key="button.failue"/>
    </html:submit>
    <html:submit property="method">
        <bean:message key="button.success"/>
    </html:submit>
</html:form>
</body>
</html>