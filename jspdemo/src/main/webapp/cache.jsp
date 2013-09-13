<%@ page import="net.sf.ehcache.CacheManager" %>
<%@ page import="net.sf.ehcache.Cache" %>
<%@ page import="net.sf.ehcache.Ehcache" %>
<%@ page import="net.sf.ehcache.Element" %>
<%@ page import="java.util.Date" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 13-9-11
  Time: 下午4:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<html>
<head>
    <title></title>
</head>
<body>
<%! CacheManager cacheManager = CacheManager.getInstance(); %>
<%! Ehcache cache = cacheManager.getEhcache("testCache"); %>
<%! int nextId = 0; %>
<%
    request.getSession(true);
    cache.put(new Element(nextId++, new Date()));
//    System.out.println(cache.getStatistics());
%>
<%= cache.getStatistics() %>
</body>
</html>