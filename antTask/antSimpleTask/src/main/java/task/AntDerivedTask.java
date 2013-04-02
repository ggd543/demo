package task;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;
import org.apache.tools.ant.TaskContainer;

public class AntDerivedTask extends Task  {

    private String msg;

    public void setMessage(String msg) {
        this.msg = msg;
    }

    public String getMessage() {
        return this.msg;
    }

    public void execute() {
        // use of the reference to Project-instance
        String projectName = getProject().getProperty("ant.project.name");
        log("Here is project '" + projectName + "'.");
        // where this task is used?
        log("I am used in: " + getLocation());

        if (this.msg == null) throw new BuildException("No Message set");
        log(msg);   // log method can't accept null vlaue

    }


}