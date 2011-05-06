<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <script type="text/javascript">
        function onlogout() {
            DeleteCookie("sessionKey");
            DeleteCookie("lastVisit");
            alert('已登出');
           // parent.location = "index.jsp";
        }

        function DeleteCookie(name) {
            var exp = new Date();
            exp.setTime(exp.getTime() - 1);
            var cval = GetCookie(name);
            document.cookie = name + "=" + cval;
            document.cookie = "expires=" + exp.toGMTString();
        }

        //取得名称为name的cookie值
        function GetCookie(name) {
            //将多cookie切割为多个名/值对
            var arrCookie = document.cookie.split("; ");
            //遍历cookie数组，处理每个cookie对
            for (var i = 0; i < arrCookie.length; i++) {
                var arr = arrCookie[i].split("=");
                //找到名称为userId的cookie，并返回它的值
                if (name == arr[0]) {
                    return arr[1];
                }
            }
        }

    </script>
</head>

<body style="FONT-SIZE: 14px;	COLOR: orange;	FONT-FAMILY: 微软雅黑;">
<center>
    <div style="width: 10%"></div>
    <div style="width: 80%; border:red solid; border:2" cellspacing="1" cellpadding="1">
        <table width="100%">
            <tr>
                <td align="left" style="width: 50%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;淘宝，梦想开始的地方</td>
                <td align="right" style="width: 50%">
                    <a href="#" onclick="onlogout()">登出(清空Cookie)</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </td>
            </tr>
        </table>
    </div>
    <div style="width: 10%">

    </div>
</center>
</body>
</html>