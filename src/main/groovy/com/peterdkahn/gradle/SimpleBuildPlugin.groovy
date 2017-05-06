package com.peterdkahn.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project

import java.util.jar.Manifest

/**
 * Created by pkahn on 5/5/2017.
 */
class SimpleBuildPlugin implements Plugin<Project> {
    void apply(Project project) {
        project.task('greatingTask', type: GreetingTask)

        try {
            URLClassLoader loader = (URLClassLoader) getClass().getClassLoader()
            URL url = loader.findResource("META-INF/MANIFEST.MF")
            Manifest manifest = new Manifest(url.openStream())
            manifest.mainAttributes.each {
                project.logger.lifecycle("${this.class.name}: ${it}")
            }
        } catch (IOException err) {
            project.logger.warn("Cannot read ${this.class.name} manifest")
        }
    }
}
