package org.ashlarbox.pojomatic.testobject;

import org.ashlarbox.pojomatic.PojomaticObject;
import org.pojomatic.annotations.AutoProperty;
import org.pojomatic.annotations.DefaultPojomaticPolicy;
import org.pojomatic.annotations.PojomaticPolicy;
import org.pojomatic.annotations.Property;

@AutoProperty(policy = DefaultPojomaticPolicy.EQUALS_TO_STRING)
public class YourPojomaticObject extends PojomaticObject {

    private Long id;

    @Property(policy = PojomaticPolicy.ALL)
    private String username;

    private String name;

    private String address;

    @Property(policy = PojomaticPolicy.EQUALS)
    private String password;
}
