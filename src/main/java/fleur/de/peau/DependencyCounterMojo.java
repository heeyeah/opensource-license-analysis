package fleur.de.peau;

import org.apache.maven.model.Dependency;
import org.apache.maven.model.License;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

import java.util.List;

/**
 * Counts the number of maven dependencies of a project.
 * <p>
 * It can be filtered by scope.
 */
@Mojo(name = "dependency-counter", defaultPhase = LifecyclePhase.PACKAGE)
public class DependencyCounterMojo extends AbstractMojo {

    /**
     * Scope to filter the dependencies.
     */
    @Parameter(property = "scope")
    String scope;

    /**
     * Gives access to the Maven project information.
     */
    @Parameter(defaultValue = "${project}", required = true, readonly = true)
    MavenProject project;

    public void execute() throws MojoExecutionException, MojoFailureException {

        List<License> licenses = project.getLicenses();
        List<Dependency> dependencies = project.getDependencies();

        long numDependencies = dependencies.stream()
                .filter(d -> (scope == null || scope.isEmpty()) || scope.equals(d.getScope()))
                .count();

        getLog().info("Number of dependencies: " + numDependencies);
        dependencies.stream().forEach(dependency -> {
            getLog().info("----depedencies detail: artifactId: " + dependency.getArtifactId());
            getLog().info(dependency.getType());
            getLog().info(dependency.getVersion());
            getLog().info(dependency.getManagementKey());
        });

    }

}