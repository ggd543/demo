importPackage(Packages.beans);
var bean = getBean("session", "demo");
if (!bean) {
    bean = new DemoBean();
    setBean("session", "demo", bean);
}
bean.counter++;
println(bean.counter);