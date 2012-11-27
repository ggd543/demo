//package jna;
//
//import com.sun.jna.Library;
//import com.sun.jna.Native;
//import com.sun.jna.Platform;
//
///**
// * User: 刘永健
// * Date: 12-10-4
// * Time: 下午9:59
// * To change this template use File | Settings | File Templates.
// */
//public class JNADemo {
//
//
//    //编写一个接口，必须继承Library，他要在加载库文件时用
//    public interface CLibrary extends Library {
//        //加载库文件，Platform.isWindows()可以判断系统类型
//        CLibrary INSTANCE = (CLibrary) Native.loadLibrary(
//                (Platform.isWindows() ? "msvcrt" : "c"), CLibrary.class);
//
//        //定义方法，与c语言标准的一致
//        void printf(String format, Object... args);
//    }
//
//    public static void main(String[] args) {
//        //调用
//        CLibrary.INSTANCE.printf("%d----%f--", 5, 5.2f);
//
//        final User32 user32 = User32.INSTANCE;
//        System.out.println(user32);
//        final Kernel32 kernel32 = Kernel32.INSTANCE;
//        System.out.println(kernel32.toString());
//    }
//}
//
//
