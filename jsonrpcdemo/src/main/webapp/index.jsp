<html>
<script type="text/javascript" src="<%= request.getContextPath()%>/resources/jquery-1.9.1.js"></script>
<script type="text/javascript" src="<%= request.getContextPath()%>/resources/jsonrpc.js"></script>
<script type="text/javascript">
    $(function () {
        $('#rpc_call').click(function(){

        });
    });
</script>
<body>
<button id="rpc_call">rpc_call</button>
<div id="rpc_result">

</div>
</body>
</html>
