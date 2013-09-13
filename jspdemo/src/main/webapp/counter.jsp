<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 12-2-9
  Time: 上午10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="true"  %>
<html>
<head>
    <title></title>
</head>
<body>

<%
    String THE_KEY_OF_COUNTER = "counter";
    Integer counter = (Integer) session.getAttribute(THE_KEY_OF_COUNTER);

    if (counter == null) {
        counter = new Integer(1);
    } else {
        counter = new Integer(counter.intValue() + 1);
    }
    session.setAttribute(THE_KEY_OF_COUNTER, counter);
    String msg = String.format("This is your %s to visit this page", counter.intValue() == 1 ? "first time" : counter + " times");
    out.println(msg);
    System.out.println("sessionId: " + session.getId() + " " + msg);

%>

</body>
</html>