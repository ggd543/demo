/*
 * @(#) HelloworldFilter.java
 * @Author:liuyongjian(liuyongjian@travelsky.com) 2013-03-15
 * @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
 */
package ch.qos.logback.demo;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author liuyongjian
 * @version 1.0
 */
public class HelloworldFilter implements Filter {
    private static Logger logger = LoggerFactory.getLogger(HelloworldFilter.class);
    private ServletContext servletContext;
    private String encoding;
    private String contentType;

    public void init(FilterConfig filterConfig) throws ServletException {
        servletContext = filterConfig.getServletContext();
        encoding = servletContext.getInitParameter("CharacterEncoding");
        if (StringUtils.isEmpty(encoding)) {
            encoding = "UTF-8";
        }
        contentType = servletContext.getInitParameter("ContentType");
        if (StringUtils.isEmpty(contentType)) {
            contentType = "text/html; charset=utf-8";
        }
        logger.info(filterConfig.getFilterName() + " init, encoding -> " + encoding + " contentType -> " + contentType);
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding(encoding);
        response.setContentType(contentType);
        chain.doFilter(request, response);
    }

    public void destroy() {
        // do something when servlet container is shutting down
    }
}
