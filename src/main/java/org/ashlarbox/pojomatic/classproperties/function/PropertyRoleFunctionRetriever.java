package org.ashlarbox.pojomatic.classproperties.function;

import org.pojomatic.internal.PropertyRole;

import java.util.Map;

import static com.google.common.collect.Maps.newHashMap;

public class PropertyRoleFunctionRetriever {

    private static Map<PropertyRole, ClassPropertiesFunction> PROPERTY_ROLE_FUNCTION = newHashMap();

    private static EqualsClassPropertiesFunction EQUALS_FUNCTION = new EqualsClassPropertiesFunction();
    private static HashCodeClassPropertiesFunction HASH_CODE_FUNCTION = new HashCodeClassPropertiesFunction();
    private static ToStringClassPropertiesFunction TO_STRING_FUNCTION = new ToStringClassPropertiesFunction();

    static {
        PROPERTY_ROLE_FUNCTION.put(PropertyRole.EQUALS, EQUALS_FUNCTION);
        PROPERTY_ROLE_FUNCTION.put(PropertyRole.HASH_CODE, HASH_CODE_FUNCTION);
        PROPERTY_ROLE_FUNCTION.put(PropertyRole.TO_STRING, TO_STRING_FUNCTION);
    }

    public ClassPropertiesFunction retrieve(PropertyRole propertyRole) {
        return PROPERTY_ROLE_FUNCTION.get(propertyRole);
    }
}
