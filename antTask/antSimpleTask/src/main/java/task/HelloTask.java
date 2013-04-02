/*
 * @(#) HelloTask.java
 * @Author:liuyongjian(liuyongjian@travelsky.com) 2013-04-02
 * @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
 */
package task;

import org.apache.tools.ant.Task;

/**
 * @author liuyongjian
 * @version 1.0
 */
public class HelloTask extends Task implements org.apache.tools.ant.TaskContainer {
    private Task info;
    private int count;

    public void execute() {
        for (int i = 0; i < count; i++)
            info.execute();
    }

    public void setCount(int c) {
        this.count = c;
    }

    public void addTask(Task t) {
        this.info = t;
    }
}