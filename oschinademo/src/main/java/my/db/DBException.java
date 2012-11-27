/*
 * 
 * User: 刘永健
 * Date: 12-11-18
 * Time: 上午10:15
 * To change this template use File | Settings | File Templates.
 */
package my.db;

public class DBException extends  RuntimeException {
    public DBException(String s) {
        super(s);
    }

    public DBException(String s, Throwable e) {
        super(s, e);
    }

    public DBException(Throwable e) {
        super(e);
    }
}
