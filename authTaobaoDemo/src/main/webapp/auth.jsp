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
                String einfo = "����authrize����:\n" + tmp;
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
            document.getElementsByName("url")[0].value = select.selectedIndex != 0 ? select.options[select.selectedIndex].text : "����д����Ӧ�ûص�URL";
        }
        function writeNick(select) {
            document.getElementsByName("nickS")[1].value = select.selectedIndex != 0 ? select.options[select.selectedIndex].text : "--����������ǳ�--";
        }
        function processSubmit() {
            var es = document.getElementsByName("nickS");
            var nick = es[0].style.display != "none" ? es[0].value : es[1].value;
            if (nick == "" || nick == "--����������ǳ�--") {
                alert("--����������ǳ�--");
                es[1].focus();
                return false;
            }
            var url = document.getElementsByName("url")[0];
            if (url.value == "" || url.value == "����д����Ӧ�ûص�URL") {
                alert("����д����Ӧ�ûص�URL");
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
        <caption>��ʼ����ϵͳ</caption>
        <tr>
            <td><img src="http://open.taobao.com/assets/images/top_logo.gif"></td>
        </tr>
        <tr>
            <td>
                ѡ��Ӧ��:
                <select name="appKey">
                    <option value="12010160" selected="selected">����</option>
                    <!--�������ҵ�Ӧ��appKey-->
                </select>
            </td>
        </tr>
        <tr>
            <td>
                �ʺ�ѡ��
                <input type="radio" name="zhxz" value="1" onclick="nickEcho(this.value);">ϵͳĬ��
                <input type="radio" name="zhxz" value="2" checked="checked" onclick="nickEcho(this.value);">�Զ���
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
                <input type="text" name="nickS" value="--����������ǳ�--" onfocus="if (this.value =='--����������ǳ�--') this.value
                = '';"onblur="if (this.value == "")this.value="--����������ǳ�--";">
                <select name="nickS" onchange="writeNick(this);">
                    <option selected="selected">����ǳ�</option>
                    <option>ʱ��֮��</option>
                    <!--������������ɳ����ע����سƼ��ɣ�һ���������ɳ���˻���һ��ʱ���Ż���Ч-->
                </select>
            </td>
        </tr>
        <tr>
            <td>
                <input type="text" name="url" value="����д����Ӧ�ûص�URL" size="40"
                       onfocus="if('����д����Ӧ�ûص�URL' ==this.value) this.value='';"
                       onblur="if('' == this.value)this.value='����д����Ӧ�ûص�URL';">
            </td>
        </tr>
        <tr>
            <td>
                �ص���
                <select onchange="writeUrl(this);">
                    <option selected="selected">���</option>
                    <option><%=basePath %>topLogin.do</option>
                    <!--�������ҵ�top��¼��ڣ����ڽ����Ա���Ȩ��Ļص�ҳ��-->
                </select>
            </td>
        </tr>
        <tr>
            <td align="center">
                <input type="submit" value="��Ȩ-->��¼ϵͳ">
            </td>
        </tr>
    </table>
</form>
</body>
</html>