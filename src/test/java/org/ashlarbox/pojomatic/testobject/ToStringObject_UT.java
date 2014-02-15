package org.ashlarbox.pojomatic.testobject;

import org.ashlarbox.pojomatic.PojomaticTester;

import java.util.Set;

import static com.google.common.collect.Sets.newHashSet;

public class ToStringObject_UT extends PojomaticTester {

    @Override
    public Class getTestClass() {
        return ToStringObject.class;
    }

    @Override
    public Set<String> getToStringFields() {
        return newHashSet("id", "username", "name", "address");
    }
}
