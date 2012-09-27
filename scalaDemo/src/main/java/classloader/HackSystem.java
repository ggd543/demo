package classloader;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 12-7-1
 * Time: 下午9:27
 * To change this template use File | Settings | File Templates.
 */

import java.io.*;
import java.nio.channels.Channel;
import java.util.Map;
import java.util.Properties;

/**
 * 为JavaClass 劫持java.lang.System 提供支持
 * 除了out和err外， 其余的都直接转发给System处理
 */
public class HackSystem {
    public final static InputStream in = System.in;
    private static ByteArrayOutputStream buffer = new ByteArrayOutputStream();
    public final static PrintStream out = new PrintStream(buffer);
    public final static PrintStream err = out;

    public static String getBufferString() {
        return buffer.toString();
    }

    public static void clearBuffer() {
        buffer.reset();
    }

    public static void setSecurityManager(final SecurityManager s) {
        System.setSecurityManager(s);
    }

    public static SecurityManager getSecurityManager() {
        return System.getSecurityManager();
    }

    public static long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length) {
        System.arraycopy(src, srcPos, dest, destPos, length);
    }

    public static String clearProperty(String key) {
        return System.clearProperty(key);
    }

    public static Console console() {
        return System.console();
    }

    public static void exit(int status) {
        System.exit(status);
    }

    public static void gc() {
        System.gc();
    }

    public static Map<String, String> getenv() {
        return System.getenv();
    }

    public static String getenv(String key) {
        return System.getenv(key);
    }

    public static Properties getProperties() {
        return System.getProperties();
    }

    public static String getProperty(String key) {
        return System.getProperty(key);
    }

    public static String getProperty(String key, String defaultValue) {
        return System.getProperty(key, defaultValue);
    }

    public static int identityHashCode(Object obj) {
        return System.identityHashCode(obj);
    }

    public static Channel inheritedChannel() throws IOException {
        return System.inheritedChannel();
    }

    public static void load(String filename) {
        System.load(filename);
    }

    public static void loadLibrary(String filename) {
        System.loadLibrary(filename);
    }

    public static void mapLibraryName(String libname) {
        System.mapLibraryName(libname);
    }

    public static long nanoTime() {
        return System.nanoTime();
    }

    public static void runFinalization() {
        System.runFinalization();
    }

    @Deprecated
    public static void runFinalizersOnExit(boolean value) {
        System.runFinalizersOnExit(value);
    }

    public static void setErr(PrintStream err) {
        System.setErr(err);
    }

    public static void setIn(InputStream in) {
        System.setIn(in);
    }

    public static void setOut(PrintStream out) {
        System.setOut(out);
    }

    public static void setProperties(Properties props) {
        System.setProperties(props);
    }

    public static String setProperty(String key, String value){
        return System.setProperty(key, value);
    }

}
