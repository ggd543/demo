package com.ggd543.demo;

/**
 * 功能描述：
 * <p> 版权所有：优视科技
 * <p> 未经本公司许可，不得以任何方式复制或使用本程序任何部分 <p>
 *
 * @author <a href="mailto:liuyj3@ucweb.com">刘永健</a>
 * @version 1.0.0
 * @since 1.0.0
 * create on: 2014年01月06
 */
public class Hello implements  HelloMBean{
    private String name;
    @Override
    public String getName() {
        System.out.println("getName invoke");
        return this.name;
    }

    @Override
    public void setName(String name) {
        System.out.println("setName invoke");
        this.name = name;
    }

    @Override
    public void printHello() {
        System.out.println("hello world , "+name);
    }

    @Override
    public void printHello(String whoName) {
        System.out.println("hello, "+whoName);
    }
}
