/*
 * @(#) HelloMojo.java
 * @Author:liuyongjian(liuyongjian@travelsky.com) 2013-04-17
 * @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
 */
package com.ggd543.mojo;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

/**
 * @author liuyongjian
 * @version 1.0
 *
 * @goal hello
 * @phase validate
 */
public class HelloMojo extends AbstractMojo {
    /**
     *
     * @throws MojoExecutionException
     * @throws MojoFailureException
     */
    public void execute() throws MojoExecutionException, MojoFailureException {
        getLog().info(Thread.currentThread()+" : fuxk Hello world..............................");
    }
}
