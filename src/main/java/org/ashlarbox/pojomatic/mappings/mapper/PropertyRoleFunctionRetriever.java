package org.ashlarbox.pojomatic.mappings.mapper;

import org.ashlarbox.pojomatic.mappings.function.MapEqualsFieldFunction;
import org.ashlarbox.pojomatic.mappings.function.MapHashCodeFieldFunction;
import org.ashlarbox.pojomatic.mappings.function.MapToStringFieldFunction;
import org.ashlarbox.pojomatic.mappings.function.PojomaticMappingFunction;
import org.pojomatic.internal.PropertyRole;

import java.util.Map;

import static com.google.common.collect.Maps.newHashMap;

public class PropertyRoleFunctionRetriever {

    private static Map<PropertyRole, PojomaticMappingFunction> PROPERTY_ROLE_FUNCTION = newHashMap();

    private static MapEqualsFieldFunction mapEqualsFieldFunction = new MapEqualsFieldFunction();
    private static MapHashCodeFieldFunction mapHashCodeFieldFunction = new MapHashCodeFieldFunction();
    private static MapToStringFieldFunction mapToStringFieldFunction = new MapToStringFieldFunction();

    static {
        PROPERTY_ROLE_FUNCTION.put(PropertyRole.EQUALS, mapEqualsFieldFunction);
        PROPERTY_ROLE_FUNCTION.put(PropertyRole.HASH_CODE, mapHashCodeFieldFunction);
        PROPERTY_ROLE_FUNCTION.put(PropertyRole.TO_STRING, mapToStringFieldFunction);
    }

    public PojomaticMappingFunction retrieve(PropertyRole propertyRole) {
        return PROPERTY_ROLE_FUNCTION.get(propertyRole);
    }
}
