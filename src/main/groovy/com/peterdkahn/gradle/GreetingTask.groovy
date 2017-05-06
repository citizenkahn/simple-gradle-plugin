package com.peterdkahn.gradle

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Optional
import org.gradle.api.tasks.TaskAction

/**
 * Created by pkahn on 5/5/2017.
 */
class GreetingTask extends DefaultTask {

    @Optional
    String text = 'helloworld'

    @TaskAction
    void action() {
        println "#####\n${text}\n####"
    }


    void methodThrowsIOException() throws IOException {
        throw new IOException("Simple test for Expected Exception")
    }
}
