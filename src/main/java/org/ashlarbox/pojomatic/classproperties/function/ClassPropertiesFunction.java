package org.ashlarbox.pojomatic.classproperties.function;

import org.pojomatic.PropertyElement;
import org.pojomatic.internal.ClassProperties;

import java.util.Collection;

public interface ClassPropertiesFunction {
    Collection<PropertyElement> getPropertyElements(ClassProperties classProperties);
}
