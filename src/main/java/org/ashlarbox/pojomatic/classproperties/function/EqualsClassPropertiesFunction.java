package org.ashlarbox.pojomatic.classproperties.function;

import org.pojomatic.PropertyElement;
import org.pojomatic.internal.ClassProperties;

import java.util.Collection;

public class EqualsClassPropertiesFunction implements ClassPropertiesFunction {

    @Override
    public Collection<PropertyElement> getPropertyElements(ClassProperties classProperties) {
        return classProperties.getEqualsProperties();
    }

}
