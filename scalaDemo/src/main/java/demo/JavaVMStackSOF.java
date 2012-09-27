package demo;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 12-6-17
 * Time: 下午10:05
 * To change this template use File | Settings | File Templates.
 */
public class JavaVMStackSOF {
    private int stackLength = 1;

    public void stackLeak(){
        stackLength++;
        stackLeak();
    }

    public static  void main(String[] args) {
        JavaVMStackSOF com = new JavaVMStackSOF();
        com.stackLeak();
    }
}
