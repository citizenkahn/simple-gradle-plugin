package com.peterdkahn.gradle

import org.hamcrest.core.StringContains
import org.junit.Before
import org.junit.Test

import static org.junit.Assert.*

/**
 * Created by pkahn on 5/5/2017.
 */
class PluginTest extends BaseTestClass {
    File testDir
    GreetingTask task

    @Before
    public void setup() {
        testDir = createTestDir()
        task = (GreetingTask) project.task(name.methodName, type: GreetingTask)
    }

    @Test
    void happyPathDefaultTest() {
        assertEquals("helloworld", task.text)
    }

    @Test
    void expectAnExceptionTest() {
        // Expect Exception
        exceptionExpected.expect(IOException.class)
        exceptionExpected.expectMessage(
                new StringContains("wrong TEXT")
        )

        // When call method guaranteed to throw
        task.methodThrowsIOException()

        // Then - fail bacause we match wrong text
    }
}
