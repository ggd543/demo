<%@page import="org.apache.log4j.*"%>
<html>
	<body>
		<%
			Logger myLogger=Logger.getLogger("LOG4JDEMO");
			myLogger.error("This is a log message from the "+myLogger.getName());
		%>
		index page
	</body>
</html>