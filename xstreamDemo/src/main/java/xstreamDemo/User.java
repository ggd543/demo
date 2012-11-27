/* 
 * Date: 12-11-26
 * Time: 下午4:37
 * To change this template use File | Settings | File Templates.
 */
package xstreamDemo;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @author 张永生(yszhang@travelsky.com), 刘永健(http://my.oschina.net/aiguozhe)
 */

@XStreamAlias("user")
public  class User{
    @XStreamAlias("name")
    public String username;
    public String password;

    User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}