<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="com.taobao.open.javaDemo.domain.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <script type="text/javascript">

        function hidden() {
            var type = document.getElementById("order_type");
            var div = document.getElementById("delivery");
            if (type.value == "delivery_needed") {
                div.style.display = "block";
            }
            if (type.value == "virtual_goods") {
                div.style.display = "none";
            }

        }

        function getAreas(type) {
            var parentId = null;
            if (type == 1) {
                parentId = 1;
            } else {
                parentId = type.value;
                document.getElementById("seller_area_id").value = parentId;

            }
            var url = window.location.href;
            var end = url.indexOf("send.do");
            url = url.substring(0, end);
            url = url + "area.do?parentId=" + parentId;
            if (window.XMLHttpRequest) {
                req = new XMLHttpRequest();
            } else if (window.ActiveXObject) {
                req = new ActiveXObject("Microsoft.XMLHTTP");
            }
            req.open("GET", url, true);
            req.onreadystatechange = onback;
            req.send(null);
        }

        function onback() {
            if (req.readyState == 4) {
                if (req.status == 200) {
                    var msg = req.responseXML.getElementsByTagName("area");

                    var select = document.getElementById("area" + msg[0].getElementsByTagName("type")[0].childNodes[0].wholeText);
                    var selects = document.getElementsByTagName("select");
                    var flag = false;
                    for (var int = 0; int < selects.length; int++) {
                        if (selects[int] == select) {
                            flag = true;
                        }
                        if (flag == true) {
                            selects[int].innerHTML = "";
                        }
                    }

                    for (var int = 0; int < msg.length; int++) {
                        var objectOption = document.createElement("option");
                        objectOption.value = msg[int].getElementsByTagName("id")[0].childNodes[0].wholeText;

                        objectOption.text = msg[int].getElementsByTagName("name")[0].childNodes[0].wholeText;
                        select.options.add(objectOption);
                    }
                }
            }
        }

    </script>
</head>
<body onload="getAreas(1);" style="FONT-SIZE: 14px;	COLOR: #003366;	FONT-FAMILY: 微软雅黑;">
<center>
    <form action="send.do" method="post">
        <table style="border:orange solid; border:1" width="800" cellspacing="1" cellpadding="1" align="center">
            <input type="hidden" name="tid" value="<%=request.getAttribute("tid") %>">
            <tr>
                <td>发货类型</td>
                <td><select id="order_type" name="order_type" onchange="hidden();">
                    <option selected=true value="delivery_needed">物流发货</option>
                    <option value="virtual_goods">虚拟发货</option>
                </select></td>
            </tr>
            <tr>
                <td colspan="2">
                    <div id="delivery">
                        <table style="border:orange solid; border:1" width="800" cellspacing="1" cellpadding="1"
                               align="center">
                            <tr>
                                <td>物流公司代码</td>
                                <td>
                                    <%
                                        LogisticsCompaniesGetResponse taobaoResponse = (LogisticsCompaniesGetResponse) request.getAttribute("company_code");
                                        LogisticsCompany[] companies = taobaoResponse.getLogisticsCompanies();
                                    %>
                                    <select name="company_code">
                                        <%for (int i = 0; i < companies.length; i++) { %>
                                        <option value="<%=companies[i].getCode() %>"><%=companies[i].getName() %>
                                        </option>
                                        <%} %>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td>标准地区码手动填入</td>
                                <td>
                                    <input type="text" id="seller_area_id" name="seller_area_id">
                                </td>
                            </tr>
                            <tr>
                                <td>标准地区码选择</td>
                                <td>
                                    <select id="area2" onchange="getAreas(this);">

                                    </select>
                                    <select id="area3" onchange="getAreas(this);">

                                    </select>
                                    <select id="area4" onchange="getAreas(this);">

                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td>运单号</td>
                                <td><input type="text" name="out_sid"></td>
                            </tr>
                            <tr>
                                <td>卖家姓名</td>
                                <td><input type="text" name="seller_name"></td>
                            </tr>
                            <tr>
                                <td>卖家地址</td>
                                <td><input type="text" name="seller_address"></td>
                            </tr>
                            <tr>
                                <td>邮编</td>
                                <td><input type="text" name="seller_zip"></td>
                            </tr>
                            <tr>
                                <td>手机号</td>
                                <td><input type="text" name="seller_mobile"></td>
                            </tr>
                            <tr>
                                <td>备注</td>
                                <td><input type="text" name="memo"></td>
                            </tr>

                        </table>
                    </div>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="right"><input type="submit" value="发货"></td>
            </tr>
        </table>
    </form>
</center>
</body>
</html>