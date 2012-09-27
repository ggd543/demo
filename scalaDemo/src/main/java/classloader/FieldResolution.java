package classloader;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 12-7-4
 * Time: 下午11:16
 * To change this template use File | Settings | File Templates.
 */
public class FieldResolution {
    interface IA0{
        int A= 0;
    }

    interface IA1 extends  IA0{
        int A = 1;
    }

    interface  IA2{
        int A= 2;
    }

    static  class Parent implements  IA1{
        public  static  int A = 11;
    }

    static  class  Sub  implements  IA2 , IA1{
        public static int A = 22;
        static {

        }
    }

    public  static  void main(String [] args){
        System.out.println(Sub.A);
    }

}
