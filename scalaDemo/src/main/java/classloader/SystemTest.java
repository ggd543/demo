package classloader;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 12-7-2
 * Time: 上午12:01
 * To change this template use File | Settings | File Templates.
 */
public class SystemTest {
    public static void main(String[] args) {
//        System.load("D:\\workspace\\tmp\\User.class");
        System.out.println(System.getProperty("java.library.path"));
//        System.loadLibrary("sunmscapi.jar");
    }
}
