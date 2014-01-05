package com.ggd543.webservice;

import javax.jws.WebService;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-10-5
 * Time: 下午7:16
 * To change this template use File | Settings | File Templates.
 */
@WebService
public interface HelloWorld {
    public String sayHello(String name);
}


