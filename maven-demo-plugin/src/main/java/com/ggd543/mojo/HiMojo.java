/*
 * @(#) HiMojo.java
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
 * @goal hi
 * @phase clean
 */
public class HiMojo extends AbstractMojo{

    public void execute() throws MojoExecutionException, MojoFailureException {
            getLog().info(Thread.currentThread()+ " hi mojo!!");
    }
}
