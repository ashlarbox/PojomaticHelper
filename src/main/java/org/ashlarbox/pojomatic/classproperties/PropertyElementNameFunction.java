package org.ashlarbox.pojomatic.classproperties;

import com.google.common.base.Function;
import org.pojomatic.PropertyElement;

public class PropertyElementNameFunction implements Function<PropertyElement, String> {

    @Override
    public String apply(PropertyElement propertyElement) {
        return propertyElement.getName();
    }

}
