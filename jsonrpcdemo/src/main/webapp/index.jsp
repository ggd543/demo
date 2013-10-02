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
        $('#rpc_call').click(function () {
            var jsonRpcClient = new JSONRpcClient("jsonrpc");
            for (var key in jsonRpcClient.helloworld) {
                console.log(key + " : " + jsonRpcClient.helloworld[key])
            }
            var msg = jsonRpcClient.helloworld.sayHelloWorld('liu yongjian');

            $('#rpc_result').append('<p>' + msg + '</p>')
        });

        $('#getUser').click(function(){
            var jsonrpc= new JSONRpcClient("jsonrpc");
            var user = jsonrpc.helloworld.getUser(12);
            var msg = user+' - user id: '+user.id+" user.name: "+user.name;
            console.log(msg);
            $('#result_getUser').append('<p>' + msg + '</p>')
        });

        $('#sayHiToUser').click(function(){
            var jsonrpc = new JSONRpcClient("jsonrpc");
            var user = {'id': 12, 'name': 'jack'};
            var resp = jsonrpc.helloworld.sayHi(user);
            console.log(resp);
            $('#result_sayHitoUser').append('<p>' + resp + '</p>')
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
</body>
</html>
