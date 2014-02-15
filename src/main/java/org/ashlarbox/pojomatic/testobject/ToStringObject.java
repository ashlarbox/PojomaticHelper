package org.ashlarbox.pojomatic.testobject;

import org.pojomatic.Pojomatic;
import org.pojomatic.annotations.AutoProperty;
import org.pojomatic.annotations.DefaultPojomaticPolicy;

@AutoProperty(policy = DefaultPojomaticPolicy.TO_STRING)
public class ToStringObject {

    private Long id;

    private String username;

    private String name;

    private String address;

    @Override
    public final String toString() {
        return Pojomatic.toString(this);
    }
}
