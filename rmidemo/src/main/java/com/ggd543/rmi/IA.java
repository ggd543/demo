package com.ggd543.rmi;

import java.io.IOException;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 11-9-11
 * Time: 下午12:59
 * To change this template use File | Settings | File Templates.
 */
public interface IA {
    public String getEcho(String msg) throws IOException;
    public Date getDate() throws Exception;
    
}
