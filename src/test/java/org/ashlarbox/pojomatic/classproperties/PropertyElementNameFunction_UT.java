package org.ashlarbox.pojomatic.classproperties;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.pojomatic.PropertyElement;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PropertyElementNameFunction_UT {

    private PropertyElementNameFunction function = new PropertyElementNameFunction();

    @Test
    public void functionShouldReturnName() {
        String name = randomAlphabetic(13);
        PropertyElement propertyElement = mock(PropertyElement.class);
        when(propertyElement.getName()).thenReturn(name);

        String returnName = function.apply(propertyElement);

        assertThat(returnName, is(name));
    }
}
