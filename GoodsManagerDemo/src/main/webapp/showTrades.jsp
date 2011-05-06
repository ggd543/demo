<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="com.taobao.open.javaDemo.domain.*,java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.text.SimpleDateFormat" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body style="FONT-SIZE: 14px;	COLOR: #003366;	FONT-FAMILY: 微软雅黑;">
<center>
    <%
        TradesSoldGetResponse taobaoResponse = (TradesSoldGetResponse) request.getAttribute("taobaoResponse");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Trade[] trades = taobaoResponse.getTrades();
        if (trades != null) {
            for (int i = 0; i < trades.length; i++) {

    %>
    <div>
        <table style="border:orange solid; border:1" width="800" cellspacing="1" cellpadding="1" align="center">
            <tr>
                <td style="border:orange solid;" bgcolor="orange" colspan="2" height="30">订单编号：<%=trades[i].getTid()%>
                    创建时间：<%=format.format(trades[i].getCreated())%>
                </td>
            </tr>
            <tr>
                <% List<Order> orders = trades[i].getOrders(); %>
                <td style="border:orange solid; border:1" width="450" height="<%=orders.size()*150 %>">
                    <table height="<%=orders.size()*150 %>" width="450">
                        <%
                            for (int j = 0; j < orders.size(); j++) {
                                if (j % 2 == 0) {
                        %>
                        <tr bgcolor="#E5F0FF">
                                <%}else{ %>
                        <tr>
                            <%} %>
                            <td width="100">
                                <img height="60" width="60" src="<%=orders.get(j).getPicPath()%>">
                            </td width="250">
                            <td>
                                <div>
                                    <div>
                                        <%=orders.get(j).getTitle() %>
                                    </div>
                                    <% String skus = orders.get(j).getSkuPropertiesName();
                                        if (skus != null) {
                                            for (String sku : skus.split(";")) {
                                    %>
                                    <div>
                                        <%=sku%>
                                    </div>
                                    <% }
                                    }
                                    %>

                                </div>
                            </td>
                            <td width="100" align="center">
                                <div>价格*数量</div>
                                <div><%=orders.get(j).getPrice() %>*<%=orders.get(j).getNum() %>
                                </div>
                            </td>
                        </tr>

                        <% }%>

                    </table>

                </td>
                <td style="border:orange solid; border:1" width="350">
                    <div>买家昵称：<%=trades[i].getBuyerNick()%>
                    </div>
                    <div>收货信息: <%=trades[i].getReceiverState() %>
                        <%=trades[i].getReceiverCity() %>
                        <%=trades[i].getReceiverDistrict() %>
                        <%=trades[i].getReceiverAddress() %>,
                        <%=trades[i].getReceiverZip() %>,
                        <%=trades[i].getReceiverName() %>,
                        <%if (trades[i].getReceiverPhone() != null) { %>
                        <%=trades[i].getReceiverPhone() %>
                        <%} else { %>
                        <%=trades[i].getReceiverMobile() %>
                        <%} %>
                    </div>


                </td>
            </tr>
            <%if ("WAIT_SELLER_SEND_GOODS".equals(trades[i].getStatus())) {%>
            <tr>
                <td colspan="2" height="30" align="right">
                    <form action="send.do"><input type="hidden" name="tId" value="<%=trades[i].getTid()%>">
                        <input type="submit" onclick="" value="发货"></form>
                </td>
            </tr>
            <%} else { %>
            <tr>
                <td colspan="2" height="30" align="right">不是等待发货状态</td>
            </tr>
            <%}%>
        </table>
        <br><br>
    </div>
    <% }
    } else {%>
    <h1>没有货物需要管理</h1>
    <%} %>
</center>


</body>
</html>