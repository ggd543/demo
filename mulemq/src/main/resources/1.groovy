Object res = muleContext.client.request("jms://"+hostName+"?connector="+connectorRef, 1000);
System.out.println(res)
if ( res == null){
    System.out.println("no resonse");
    return "no response";
}else{
    return res
}