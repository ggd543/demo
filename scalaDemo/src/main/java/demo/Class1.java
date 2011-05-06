package demo;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 2010-12-5
 * Time: 23:18:04
 * To change this template use File | Settings | File Templates.
 */
public class Class1 {
    class Outer{
        class Inner{
            private void print() {
                System.out.println("Class1.Outer.Inner.print()");
            }
        }

        class InnerApp{
            public InnerApp(){
                Inner inner = new Inner();
                inner.print();  // ok
            }
        }
    }

    public Class1(){
        Outer outer = new Outer();
        (outer.new Inner()).print();    // ok
        outer.new InnerApp(); 
    }

    public static void main(String[] args) {
        new Class1();    

    }

    private void show(){
        System.out.println("Class1.show()");
    }

}

class Class11{
    public Class11(){
//        new Class1().print();  //compilation error
    }
}




