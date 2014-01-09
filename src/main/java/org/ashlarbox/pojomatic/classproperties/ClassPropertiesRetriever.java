package org.ashlarbox.pojomatic.classproperties;

import org.ashlarbox.pojomatic.classproperties.function.PropertyRoleFunctionRetriever;
import org.pojomatic.internal.ClassProperties;
import org.pojomatic.internal.PropertyRole;

import java.util.Set;

import static com.google.common.collect.Collections2.transform;
import static com.google.common.collect.Sets.newHashSet;

public class ClassPropertiesRetriever {

    private PropertyRoleFunctionRetriever propertyRoleFunctionRetriever = new PropertyRoleFunctionRetriever();
    private PropertyElementNameFunction propertyElementNameFunction = new PropertyElementNameFunction();

    public Set<String> retrieve(ClassProperties classProperties, PropertyRole propertyRole) {
        return newHashSet(
               transform(propertyRoleFunctionRetriever.retrieve(propertyRole).getPropertyElements(classProperties),
                       propertyElementNameFunction));
    }

}
