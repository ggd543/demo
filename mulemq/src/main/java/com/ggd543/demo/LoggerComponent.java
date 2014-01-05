package com.ggd543.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ggd543 on 14-1-5.
 */
public class LoggerComponent {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object log(String msg) {
        logger.info(name + " : " + msg);
        return msg;
    }
}
