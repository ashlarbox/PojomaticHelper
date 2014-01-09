package org.ashlarbox.pojomatic.classproperties.function;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.pojomatic.PropertyElement;
import org.pojomatic.internal.ClassProperties;

import java.util.Collection;

import static com.google.common.collect.Sets.newHashSet;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EqualsClassPropertiesFunction_UT {

    private final EqualsClassPropertiesFunction function = new EqualsClassPropertiesFunction();

    @Test
    public void functionShouldReturnEqualsProperties() {
        ClassProperties classProperties = mock(ClassProperties.class);
        Collection<PropertyElement> propertyElements = newHashSet(mock(PropertyElement.class));
        when(classProperties.getEqualsProperties()).thenReturn(propertyElements);

        Collection<PropertyElement> returnedProperties = function.getPropertyElements(classProperties);

        assertThat(returnedProperties, is(sameInstance(propertyElements)));
    }
}
