<%@ page import="com.ggd543.service.HelloWorldImpl" %>
<html>
<jsp:useBean id="JSONRPCBridge" scope="session"
             class="com.metaparadigm.jsonrpc.JSONRPCBridge"></jsp:useBean>
<%
    JSONRPCBridge.registerObject("helloworld", new HelloWorldImpl());
%>

<script type="text/javascript" src="<%= request.getContextPath()%>/resources/jquery-1.9.1.js"></script>
<script type="text/javascript" src="<%= request.getContextPath()%>/resources/jsonrpc.js"></script>
<script type="text/javascript">
    $(function () {
        var jsonrpc = new JSONRpcClient("jsonrpc");
        $('#rpc_call').click(function () {

            for (var key in jsonrpc.helloworld) {
                console.log(key + " : " + jsonrpc.helloworld[key])
            }
            var msg = jsonrpc.helloworld.sayHelloWorld('liu yongjian');

            $('#rpc_result').append('<p>' + msg + '</p>')
        });

        $('#getUser').click(function () {
            var user = jsonrpc.helloworld.getUser(12);
            var msg = user + ' - user id: ' + user.id + " user.name: " + user.name;
            console.log(msg);
            $('#result_getUser').append('<p>' + msg + '</p>')
        });

        $('#sayHiToUser').click(function () {
            var user = {'id': 12, 'name': 'jack'};
            var resp = jsonrpc.helloworld.sayHi(user);
            console.log(resp);
            $('#result_sayHitoUser').append('<p>' + resp + '</p>')
        });

        $('#query_user').click(function () {
            console.log(typeof jsonrpc.helloworld.query);
            try {
                var resp = jsonrpc.helloworld.query(0);
                console.log(resp);
                var book0 = resp[0];
                console.log("book.cn: " + book0.cn + " book.name: " + book0.name);
            } catch (e) {
                console.log(e);
            }
        });

        $('#get_usertype').click(function(){
            try{
            var resp = jsonrpc.helloworld.getUserType(0);
                console.log(resp);
            }catch(e){
                console.log(e);
            }

        });
    });
</script>
<body>
<button id="rpc_call">rpc_call</button>
<div id="rpc_result">

</div>

<div>
    <button id="getUser">getUser</button>
    <div id="result_getUser">

    </div>
</div>

<div>
    <button id="sayHiToUser">sayHiToUser</button>
    <div id="result_sayHitoUser">

    </div>
</div>

<div>
    <button id="query_user">query_user</button>
    <div id="result_query_user">

    </div>
</div>

<div>
    <button id="get_usertype">get_usertype</button>
    <div id="result_get_usertype">

    </div>
</div>
</body>
</html>
