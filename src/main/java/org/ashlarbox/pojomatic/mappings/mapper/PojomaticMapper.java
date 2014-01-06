package org.ashlarbox.pojomatic.mappings.mapper;

import org.ashlarbox.pojomatic.PojomaticObject;
import org.ashlarbox.pojomatic.mappings.PojomaticMappings;
import org.pojomatic.annotations.Property;
import org.pojomatic.internal.PropertyRole;

import java.lang.reflect.Field;

public class PojomaticMapper {

    private PropertyRoleRetriever propertyRoleRetriever = new PropertyRoleRetriever();
    private PropertyRoleFunctionRetriever propertyRoleFunctionRetriever = new PropertyRoleFunctionRetriever();

    public void setDefaultPolicy(PojomaticObject pojomaticObject) {
        propertyRoleRetriever.setDefaultPolicy(pojomaticObject);
    }

    public void mapField(Field field, PojomaticMappings pojomaticMappings) {
        for (PropertyRole role : propertyRoleRetriever.retrieve(field.getAnnotation(Property.class))) {
            propertyRoleFunctionRetriever.retrieve(role).mapField(field.getName(), pojomaticMappings);
        }
    }

}
