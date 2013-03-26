package com.ggd543.demo;

import org.junit.Test;
import junit.framework.Assert;

public class HelloworldTest {
    @Test
    public void testHello(){
        Assert.assertEquals("hello world", Helloworld.hello());
    }
}