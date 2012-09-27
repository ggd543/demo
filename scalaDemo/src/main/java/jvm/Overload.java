package jvm;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 12-7-10
 * Time: 下午10:18
 * To change this template use File | Settings | File Templates.
 */
public class Overload {

//    public static void sayHello(char arg) {
//        System.out.println("Hello char");
//    }

//    public static void sayHello(int arg) {
//        System.out.println("Hello int");
//    }

//    public static void sayHello(long arg) {
//        System.out.println("Hello long");
//    }

//    public static void sayHello(Character arg) {
//        System.out.println("Hello Charcter");
//    }
//
//    public static void sayHello(Serializable arg) {
//        System.out.println("Hello Serializable");
//    }

//    public static void sayHello(Object arg) {
//        System.out.println("Hello Object");
//    }
//
//    public static void sayHello(char... arg) {
//        System.out.println("Hello char...");
//    }

    public static void sayHello(Character... arg) {
            System.out.println("Hello Character...");
        }

    public static void main(String[] args) {
        sayHello('a');
    }

}
