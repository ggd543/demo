/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 12-12-21
 * Time: 下午5:30
 * To change this template use File | Settings | File Templates.
 */
package com.ggd543.joda;

import java.io.InputStream;

public class App {
    public static void main(String[] args) {
        System.out.println(App.class.getPackage().getName().replaceAll("\\.","/"));
        InputStream is = App.class.getResourceAsStream("/is/a.txt");
        System.out.println(is);
    }
}
