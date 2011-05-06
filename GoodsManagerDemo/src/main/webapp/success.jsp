<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>成功提示</title>
    <script type="text/javascript">
        function closewindow() {

            var href = window.location.href;
            href = href.replace("success.jsp", "welcome.jsp");
            window.location.href = href;
        }
        function clock() {
            i = i - 1;
            if (document.getElementById("info")) {
                document.getElementById("info").innerHTML = "本窗口将在" + i + "秒后自动跳转";
            }
            if (i > 0)
                setTimeout("clock();", 1000);
            else
                closewindow();
        }

        var i = 5;
        clock();

    </script>
</head>
<body style="FONT-SIZE: 14px;	COLOR: #003366;	FONT-FAMILY: 微软雅黑;">
<center>
    <h1>发货成功</h1>

    <div id="info">本窗口将在5秒后自动跳转</div>
    <input type="button" value="跳转" onclick="closewindow();">
</center>
</body>
</html>