package org.ashlarbox.pojomatic.testobject;

import org.ashlarbox.pojomatic.PojomaticTester;

import java.util.Set;

import static com.google.common.collect.Sets.newHashSet;

public class HashCodeEqualsObject_UT extends PojomaticTester {

    @Override
    public Class getTestClass() {
        return HashCodeEqualsObject.class;
    }

    @Override
    public Set<String> getEqualsFields() {
        return newHashSet("id", "username", "name", "address", "password");
    }

    @Override
    public Set<String> getHashCodeFields() {
        return newHashSet("username");
    }

}
