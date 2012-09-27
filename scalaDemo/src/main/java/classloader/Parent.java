package classloader;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 12-7-4
 * Time: 下午10:59
 * To change this template use File | Settings | File Templates.
 */
public class Parent {
    public  static  int A= 1;
    static {
        A=2;
        NAME="AAA";
//        System.out.println(NAME);  // Can't forward reference
    }
    public  static  String NAME = "Archer";

    public static void main(String[] args) {
        System.out.println(NAME);
    }

    static class Sub extends Parent{
        public  static  int B =A;

        public static void main(String[] args) {
            System.out.println("B="+B);

        }
    }
}


