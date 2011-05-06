println("start ...")
var debug = true;
var debugStartTime = java.lang.System.nanoTime();

var param = new Object();
var paramValues = new Object();

function initParams() {
    var paramNames = request.getParameterNames();
    while (paramNames.hasMoreElements()) {
        var name = paramNames.nextElement();
        param[name] = String(request.getParameter(name));
        paramValues[name] = new Array();
        var values = request.getParameterValues(name);
        for (var i = 0; i < values.length; i++)
            paramValues[name][i] = String(values[i]);
    }
}

function getBean(scope, id) {
    return eval(scope).getAttribute(id);
}

function setBean(scope, id, bean) {
    if (!bean)
        bean = eval(id);
    return eval(scope).setAttribute(id, bean);
}

var obj = eval("session")
println("session: "+obj)
println("session: "+session)
initParams();