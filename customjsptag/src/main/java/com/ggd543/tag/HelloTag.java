/*
 * @(#) HelloTag.java
 * @Author:liuyongjian(liuyongjian@travelsky.com) 2013-05-17
 * @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
 */
package com.ggd543.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * @author liuyongjian
 * @version 1.0
 */
public class HelloTag extends TagSupport {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public int doEndTag() throws JspException {
        try {
            JspWriter writer = pageContext.getOut();
            writer.println("hello " + message);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return super.doEndTag();
    }

}
