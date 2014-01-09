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
public class ToStringClassPropertiesFunction_UT {

    private final ToStringClassPropertiesFunction function = new ToStringClassPropertiesFunction();

    @Test
    public void functionShouldReturnToStringProperties() {
        ClassProperties classProperties = mock(ClassProperties.class);
        Collection<PropertyElement> propertyElements = newHashSet(mock(PropertyElement.class));
        when(classProperties.getToStringProperties()).thenReturn(propertyElements);

        Collection<PropertyElement> returnedProperties = function.getPropertyElements(classProperties);

        assertThat(returnedProperties, is(sameInstance(propertyElements)));
    }
}
