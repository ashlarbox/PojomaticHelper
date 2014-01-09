package org.ashlarbox.pojomatic;

import java.util.Set;

public interface PojomaticTest {

    void runPojomaticTests();

    Class getTestClass();

    Set<String> getEqualsFields();

    Set<String> getHashCodeFields();

    Set<String> getToStringFields();
}
