/*
 * 
 * User: 刘永健
 * Date: 12-11-18
 * Time: 上午10:16
 * To change this template use File | Settings | File Templates.
 */
package my.cache;

/**
 * 缓存异常
 * @author Winter Lau
 */
public class CacheException extends RuntimeException {

    public CacheException(String s) {
        super(s);
    }

    public CacheException(String s, Throwable e) {
        super(s, e);
    }

    public CacheException(Throwable e) {
        super(e);
    }

}
