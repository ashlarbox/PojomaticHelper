package org.ashlarbox.pojomatic.testobject;

import org.pojomatic.Pojomatic;
import org.pojomatic.annotations.AutoProperty;
import org.pojomatic.annotations.DefaultPojomaticPolicy;
import org.pojomatic.annotations.PojomaticPolicy;
import org.pojomatic.annotations.Property;

@AutoProperty(policy = DefaultPojomaticPolicy.EQUALS)
public class HashCodeEqualsObject {

    private Long id;

    @Property(policy = PojomaticPolicy.HASHCODE_EQUALS)
    private String username;

    private String name;

    private String address;

    private String password;

    @Override
    public final boolean equals(Object o) {
        return Pojomatic.equals(this, o);
    }

    @Override
    public final int hashCode() {
        return Pojomatic.hashCode(this);
    }

}
