var Jscex = require("jscex");
require("jscex-jit").init(Jscex);
require("jscex-async").init(Jscex);
require("jscex-async-powerpack").init(Jscex);

var fib = eval(Jscex.compile("async", function () {

    $await(Jscex.Async.sleep(1000)); // ����ͣ��һ��
    console.log(0);

    $await(Jscex.Async.sleep(1000)); // ����ͣ��һ��
    console.log(1);

    var a = 0, current = 1;
    while (true) {
        var b = a;
        a = current;
        current = a + b;

        $await(Jscex.Async.sleep(1000)); // ����ͣ��һ��
        console.log(current);
    }
}));

fib().start();