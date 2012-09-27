package classloader;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 12-7-1
 * Time: 下午8:20
 * To change this template use File | Settings | File Templates.
 */

/**
 * 为了多次载入执行类而加入的加载器<br/>
 * 把defineClass的方法开放出来，只有外部显式调用的时候才会使用到loadByte方法
 * 由虚拟机调用时,仍按照原有的双亲委派规则使用loadClass方法进行类加载
 */
public class HotSwapClassLoader extends ClassLoader{
    public HotSwapClassLoader(){
        super(HotSwapClassLoader.class.getClassLoader());
    }

    public Class loadByte(byte[] buf){
        return defineClass(null, buf, 0 ,buf.length);
    }

}
