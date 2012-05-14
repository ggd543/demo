package com.ggd543.maven.plugin;

import org.apache.maven.artifact.Artifact;
import org.apache.maven.artifact.factory.ArtifactFactory;
import org.apache.maven.model.Dependency;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugin.logging.Log;
import org.apache.maven.project.MavenProject;

import java.util.List;

/**
 * User: 刘永健
 * Date: 12-2-6
 * Time: 上午9:37
 * To change this template use File | Settings | File Templates.
 */

/**
 * @phase process-sources
 * @goal helloworld
 */
public class HelloWorldMojo extends AbstractMojo {
    /**
     * @parameter default-value="true"
     */
    private boolean readOnly;
    /**
     * @parameter expression="${name}" default-value="Tom"
     * @required
     */
    private String name;
    /**
     * @component
     * @readonly
     */
    private ArtifactFactory artifactFactory;

    /**
     * @parameter expression="${project}"
     * @readonly
     */
    private MavenProject project;

    private Log log = getLog();

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        log.info("Hello world!");
        log.info("name = " + name);
        log.info("readOnly = " + readOnly);
        printDependencies();
    }

    private void printDependencies()  {
        log.info("===================All dependencies=========================");

        for (Object obj : project.getDependencies()) {
            Dependency dependency = (Dependency) obj;
            log.info("groupId: " + dependency.getGroupId() + " artifactId: " + dependency.getArtifactId()
                    + " version: " + dependency.getVersion() + " scope: " + dependency.getScope()
                    + "  type: " + dependency.getType());
        }
        log.info("============================================================");
    }


}
