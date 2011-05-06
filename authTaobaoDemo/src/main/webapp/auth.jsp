<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";

    String appKey, zhxz = "2", nick = "", url;
    String msg = null;
    if (request.getParameter("appKey") != null) {
        appKey = request.getParameter("appKey");
        zhxz = request.getParameter("zhxz");
        nick = request.getParameter("nick");
        url = request.getParameter("url");
        DefaultHttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(new URI("http://open.taobao.com/isv/authorize.php?appkey=" + appKey));
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("zhxz", zhxz));
        nvps.add(new BasicNameValuePair("nick", nick));
        nvps.add(new BasicNameValuePair("url", url));
        post.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
        HttpResponse hr = client.execute(post);
        String tmp = new String(EntityUtils.toString(hr.getEntity()));
        int pos = tmp.indexOf("<input type=\"text\" id=\"autoInput\"value=\"") + "<input type=\"text\" id=\"autoInput\"value=\"".length();
        if (pos != -1) {
            try {
                String authCode = tmp.substring(pos, tmp.indexOf('"', pos));
                response.sendRedirect("http://container.api.tbsandbox.com/container?authcode=" + authCode);
            } catch (StringIndexOutOfBoundsException e) {
                String einfo = "请求authrize出错:\n" + tmp;
                LoggerFactory.getLogger(this.getClass()).warn(einfo, e);
                log(einfo, e);
            }
        }
        pos = tmp.indexOf("alert('") + "alert('".length();
        if (pos != -1) {
            msg = tmp.substring(pos, tmp.indexOf("')", pos));
        }
    }
/**
 if (request.getParameter("appKey") != null) {
 appKey = request.getParameter("appKey");
 zhxz = request.getParameter("zhxz");
 nick = request.getParameter("nick");
 url = request.getParameter("url");
 URL authorUrl = new URL("http://open.taobao.com/isv/authorize.php?appkey=" + appKey);
 HTTPRequest httpRequest = new HTTPRequest(authorUrl, HTTPMethod.POST);
 String payload = "zhxz=" + zhxz
 + "&nick=" + URLEncoder.encode(nick, "UTF-8")
 + "&url=" + URLEncoder.encode(url, "UTF-8");
 httpRequest.setPayload(payload.getBytes());
 HTTPResponse httpResponse = URLFetchServiceFactory.getURLFetchService().fetch(httpRequest);
 String tmp = new String(httpResponse.getContent());
 int pos = tmp.indexOf("<input type=\"text\" id=\"autoInput\"value=\"") + "<input type=\"text\" id=\"autoInput\"value=\"".length();
 String authCode = tmp.substring(pos, tmp.indexOf('"', pos));
 response.sendRedirect("http://container.api.tbsandbox.com/container?authcode=" + authCode);
 }
 */
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>jsp/">    
    <script type="text/javascript">
        function nickEcho(v) {
            var es = document.getElementsByName("nickS");
            if (v == 1) {
                es[0].style.display = "";
                es[1].style.display = "none";
                es[2].style.display = "none";
            } else {
                es[0].style.display = "none";
                es[1].style.display = "";
                es[2].style.display = "";
            }
        }
        function writeUrl(select) {
            document.getElementsByName("url")[0].value = select.selectedIndex != 0 ? select.options[select.selectedIndex].text : "请填写您的应用回调URL";
        }
        function writeNick(select) {
            document.getElementsByName("nickS")[1].value = select.selectedIndex != 0 ? select.options[select.selectedIndex].text : "--请输入测试昵称--";
        }
        function processSubmit() {
            var es = document.getElementsByName("nickS");
            var nick = es[0].style.display != "none" ? es[0].value : es[1].value;
            if (nick == "" || nick == "--请输入测试昵称--") {
                alert("--请输入测试昵称--");
                es[1].focus();
                return false;
            }
            var url = document.getElementsByName("url")[0];
            if (url.value == "" || url.value == "请填写您的应用回调URL") {
                alert("请填写您的应用回调URL");
                url.focus();
                return false;
            }

            document.getElementsByName("nick")[0].value = nick;
            return true;
        }
    </script>
</head>
<body>
<%
    if (msg != null) {
%>
<center>
    <h1>
        <font color="red">
            <%=msg %>
        </font>
    </h1>
</center>
<%
    }
%>
<form onsubmit="return processSubmit();" method="get">
    <table align="center">
        <caption>开始测试系统</caption>
        <tr>
            <td><img src="http://open.taobao.com/assets/images/top_logo.gif"></td>
        </tr>
        <tr>
            <td>
                选择应用:
                <select name="appKey">
                    <option value="12010160" selected="selected">盘龙</option>
                    <!--这里是我的应用appKey-->
                </select>
            </td>
        </tr>
        <tr>
            <td>
                帐号选择：
                <input type="radio" name="zhxz" value="1" onclick="nickEcho(this.value);">系统默认
                <input type="radio" name="zhxz" value="2" checked="checked" onclick="nickEcho(this.value);">自定义
                <input type="hidden" name="nick" value="">
            </td>
        </tr>
        <tr>
            <td>
                <select name="nickS" style="display: none;">
                    <option value="sandbox_c_1" selected="selected">sandbox_c_1</option>
                    <option value="sandbox_c_2">sandbox_c_2</option>
                    <option value="sandbox_c_3">sandbox_c_3</option>
                    <option value="sandbox_c_4">sandbox_c_4</option>
                    <option value="sandbox_c_5">sandbox_c_5</option>
                    <option value="sandbox_c_6">sandbox_c_6</option>
                    <option value="sandbox_c_7">sandbox_c_7</option>
                    <option value="sandbox_c_8">sandbox_c_8</option>
                    <option value="sandbox_c_9">sandbox_c_9</option>
                    <option value="sandbox_c_10">sandbox_c_10</option>
                    <option value="sandbox_c_11">sandbox_c_11</option>
                    <option value="sandbox_c_12">sandbox_c_12</option>
                    <option value="sandbox_c_13">sandbox_c_13</option>
                    <option value="sandbox_c_14">sandbox_c_14</option>
                    <option value="sandbox_c_15">sandbox_c_15</option>
                    <option value="sandbox_c_16">sandbox_c_16</option>
                    <option value="sandbox_c_17">sandbox_c_17</option>
                    <option value="sandbox_c_18">sandbox_c_18</option>
                    <option value="sandbox_c_19">sandbox_c_19</option>
                    <option value="sandbox_c_20">sandbox_c_20</option>
                    <option value="sandbox_c_21">sandbox_c_21</option>
                    <option value="sandbox_c_22">sandbox_c_22</option>
                    <option value="sandbox_c_23">sandbox_c_23</option>
                    <option value="sandbox_c_24">sandbox_c_24</option>
                    <option value="sandbox_c_25">sandbox_c_25</option>
                    <option value="sandbox_c_26">sandbox_c_26</option>
                    <option value="sandbox_c_27">sandbox_c_27</option>
                    <option value="sandbox_c_28">sandbox_c_28</option>
                    <option value="sandbox_c_29">sandbox_c_29</option>
                    <option value="sandbox_c_30">sandbox_c_30</option>
                    <option value="alipublic00">alipublic00</option>
                    <option value="alipublic01">alipublic01</option>
                    <option value="alipublic02">alipublic02</option>
                    <option value="alipublic03">alipublic03</option>
                    <option value="alipublic04">alipublic04</option>
                    <option value="alipublic05">alipublic05</option>
                    <option value="alipublic06">alipublic06</option>
                    <option value="alipublic07">alipublic07</option>
                    <option value="alipublic08">alipublic08</option>
                    <option value="alipublic09">alipublic09</option>
                    <option value="alipublic10">alipublic10</option>
                    <option value="alipublic11">alipublic11</option>
                    <option value="alipublic12">alipublic12</option>
                    <option value="alipublic13">alipublic13</option>
                    <option value="alipublic14">alipublic14</option>
                    <option value="alipublic15">alipublic15</option>
                    <option value="alipublic16">alipublic16</option>
                    <option value="alipublic17">alipublic17</option>
                    <option value="alipublic18">alipublic18</option>
                    <option value="alipublic19">alipublic19</option>
                    <option value="alipublic20">alipublic20</option>
                    <option value="alipublic21">alipublic21</option>
                    <option value="alipublic22">alipublic22</option>
                    <option value="alipublic23">alipublic23</option>
                    <option value="alipublic24">alipublic24</option>
                    <option value="alipublic25">alipublic25</option>
                    <option value="alipublic26">alipublic26</option>
                    <option value="alipublic27">alipublic27</option>
                    <option value="alipublic28">alipublic28</option>
                    <option value="alipublic29">alipublic29</option>
                </select>
                <input type="text" name="nickS" value="--请输入测试昵称--" onfocus="if (this.value =='--请输入测试昵称--') this.value
                = '';"onblur="if (this.value == "")this.value="--请输入测试昵称--";">
                <select name="nickS" onchange="writeNick(this);">
                    <option selected="selected">清空昵称</option>
                    <option>时空之蕊</option>
                    <!--这里输入你在沙箱中注册的呢称即可，一般新申请的沙箱账户过一段时间后才会生效-->
                </select>
            </td>
        </tr>
        <tr>
            <td>
                <input type="text" name="url" value="请填写您的应用回调URL" size="40"
                       onfocus="if('请填写您的应用回调URL' ==this.value) this.value='';"
                       onblur="if('' == this.value)this.value='请填写您的应用回调URL';">
            </td>
        </tr>
        <tr>
            <td>
                回调：
                <select onchange="writeUrl(this);">
                    <option selected="selected">清空</option>
                    <option><%=basePath %>topLogin.do</option>
                    <!--这里是我的top登录入口，用于接收淘宝授权后的回调页面-->
                </select>
            </td>
        </tr>
        <tr>
            <td align="center">
                <input type="submit" value="授权-->登录系统">
            </td>
        </tr>
    </table>
</form>
</body>
</html>