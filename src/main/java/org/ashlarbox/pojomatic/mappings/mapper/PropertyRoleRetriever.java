package org.ashlarbox.pojomatic.mappings.mapper;

import org.ashlarbox.pojomatic.PojomaticObject;
import org.pojomatic.annotations.AutoProperty;
import org.pojomatic.annotations.DefaultPojomaticPolicy;
import org.pojomatic.annotations.Property;
import org.pojomatic.internal.PropertyRole;

import java.util.Set;

class PropertyRoleRetriever {

    private DefaultPojomaticPolicy defaultPojomaticPolicy = DefaultPojomaticPolicy.NONE;

    public void setDefaultPolicy(PojomaticObject pojomaticObject) {
        AutoProperty annotation = pojomaticObject.getClass().getAnnotation(AutoProperty.class);
        if (annotation != null) {
            defaultPojomaticPolicy = annotation.policy();
        }
    }

    public Set<PropertyRole> retrieve(Property property) {
        return (property != null)
                ? property.policy().getRoles()
                : defaultPojomaticPolicy.getRoles();
    }

    DefaultPojomaticPolicy getDefaultPojomaticPolicy() {
        return defaultPojomaticPolicy;
    }
}
