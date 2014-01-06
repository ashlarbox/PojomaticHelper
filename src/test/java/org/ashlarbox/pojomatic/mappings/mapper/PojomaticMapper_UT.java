package org.ashlarbox.pojomatic.mappings.mapper;

import org.ashlarbox.pojomatic.PojomaticObject;
import org.ashlarbox.pojomatic.mappings.PojomaticMappings;
import org.ashlarbox.pojomatic.mappings.function.PojomaticMappingFunction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.pojomatic.annotations.PojomaticPolicy;
import org.pojomatic.annotations.Property;
import org.pojomatic.internal.PropertyRole;

import java.lang.reflect.Field;

import static com.google.common.collect.Sets.newHashSet;
import static org.apache.commons.lang.RandomStringUtils.randomAlphabetic;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PojomaticMapper_UT {

    @Mock
    private PropertyRoleRetriever propertyRoleRetriever;

    @Mock
    private PropertyRoleFunctionRetriever propertyRoleFunctionRetriever;

    @InjectMocks
    private PojomaticMapper pojomaticMapper = new PojomaticMapper();

    @Property(policy = PojomaticPolicy.EQUALS)
    private String test = randomAlphabetic(4);

    @Test
    public void setDefaultPolicyShouldSetInRetriever() {
        PojomaticObject pojomaticObject = mock(PojomaticObject.class);
        pojomaticMapper.setDefaultPolicy(pojomaticObject);
        verify(propertyRoleRetriever).setDefaultPolicy(pojomaticObject);
    }

    @Test
    public void mapFieldShouldRetrieveRolesAndCallFunctionsToMapFields() throws NoSuchFieldException {
        PojomaticMappings pojomaticMappings = mock(PojomaticMappings.class);
        Field testField = this.getClass().getDeclaredField("test");
        Property property = testField.getAnnotation(Property.class);
        PojomaticMappingFunction pojomaticMappingFunction = mock(PojomaticMappingFunction.class);

        when(propertyRoleRetriever.retrieve(property)).thenReturn(newHashSet(PropertyRole.EQUALS));
        when(propertyRoleFunctionRetriever.retrieve(PropertyRole.EQUALS)).thenReturn(pojomaticMappingFunction);

        pojomaticMapper.mapField(testField, pojomaticMappings);

        verify(pojomaticMappingFunction).mapField("test", pojomaticMappings);
    }
}
