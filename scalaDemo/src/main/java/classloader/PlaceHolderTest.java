package classloader;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 12-7-4
 * Time: 下午10:12
 * To change this template use File | Settings | File Templates.
 */
public class PlaceHolderTest  {
    public static void main(String[] args) {
        {
        byte[] buf = new byte[10 * 1024 * 1024];
        }
        int a=1;
        System.gc();
    }
}
