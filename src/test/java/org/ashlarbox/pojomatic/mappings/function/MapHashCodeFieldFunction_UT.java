package org.ashlarbox.pojomatic.mappings.function;

import org.ashlarbox.pojomatic.mappings.PojomaticMappings;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.apache.commons.lang.RandomStringUtils.randomAlphabetic;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class MapHashCodeFieldFunction_UT {

    private final MapHashCodeFieldFunction function = new MapHashCodeFieldFunction();

    @Test
    public void functionShouldBeAPojomaticMappingFunction() {
        assertThat(function, is(instanceOf(PojomaticMappingFunction.class)));
    }

    @Test
    public void functionShouldAddFieldToEqualsMapping() {
        PojomaticMappings pojomaticMappings = mock(PojomaticMappings.class);
        String field = randomAlphabetic(5);

        function.mapField(field, pojomaticMappings);

        verify(pojomaticMappings).addHashCodeField(field);
    }
}
