package com.peterdkahn.gradle

import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.BeforeClass
import org.junit.Rule
import org.junit.rules.ExpectedException
import org.junit.rules.TestName

/**
 * Created by pkahn on 5/5/2017.
 */
class BaseTestClass {
    final Date now = new Date()
    final String localHost = InetAddress.getLocalHost().getHostName()

    @Rule
    public TestName name = new TestName()

    @Rule
    public ExpectedException exceptionExpected = ExpectedException.none()

    public static Project project

    @BeforeClass
    public static void setupOnce() {
        project = ProjectBuilder.builder().build()
        project.apply plugin: 'simpleplugin'
    }

    public String uniqueName() {
        return "${now.getTime()}-${localHost}-${name.getMethodName()}"
    }

    protected File createTestDir(def testName = "${name.getMethodName()}") {
        File dir = new File("build/tests/${testName}")
        if (dir.exists()) {
            dir.deleteDir()
        }
        dir.mkdirs()
        return dir
    }
}
