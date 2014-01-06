package org.ashlarbox.pojomatic.mappings.mapper;

import org.ashlarbox.pojomatic.PojomaticObject;
import org.junit.Test;
import org.pojomatic.annotations.AutoProperty;
import org.pojomatic.annotations.DefaultPojomaticPolicy;
import org.pojomatic.annotations.PojomaticPolicy;
import org.pojomatic.annotations.Property;
import org.pojomatic.internal.PropertyRole;

import java.util.Set;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PropertyRoleRetriever_UT {

    private final PropertyRoleRetriever retriever = new PropertyRoleRetriever();

    @Test
    public void setDefaultPolicyWithoutAnnotationShouldKeepDefaultPolicyNone() {
        UnannotatedClass testObject = new UnannotatedClass();
        retriever.setDefaultPolicy(testObject);
        assertThat(retriever.getDefaultPojomaticPolicy(), is(DefaultPojomaticPolicy.NONE));
    }

    @Test
    public void setDefaultPolicyWithAnnotationShouldUpdateDefaultPolicy() {
        AnnotatedClass testObject = new AnnotatedClass();
        retriever.setDefaultPolicy(testObject);
        assertThat(retriever.getDefaultPojomaticPolicy(), is(DefaultPojomaticPolicy.HASHCODE_EQUALS));
    }

    @Test
    public void retrieverShouldRetrieveRolesOfDefaultPolicyWhenPropertyIsNull() {
        AnnotatedClass testObject = new AnnotatedClass();
        retriever.setDefaultPolicy(testObject);

        Set<PropertyRole> roles = retriever.retrieve(null);

        assertThat(roles.size(), is(2));
        assertThat(roles, hasItems(PropertyRole.EQUALS, PropertyRole.HASH_CODE));
    }

    @Test
    public void retrieverShouldRetrieveRolesOfPropertyWhenPropertyIsNotNull() throws NoSuchFieldException {
        AnnotatedClass testObject = new AnnotatedClass();
        retriever.setDefaultPolicy(testObject);
        Property property = this.getClass().getDeclaredField("testField").getAnnotation(Property.class);

        Set<PropertyRole> roles = retriever.retrieve(property);

        assertThat(roles.size(), is(1));
        assertThat(roles, hasItems(PropertyRole.TO_STRING));
    }

    private class UnannotatedClass extends PojomaticObject {}

    @AutoProperty(policy = DefaultPojomaticPolicy.HASHCODE_EQUALS)
    private class AnnotatedClass extends PojomaticObject {}

    @Property(policy = PojomaticPolicy.TO_STRING)
    private String testField = "42";
}
