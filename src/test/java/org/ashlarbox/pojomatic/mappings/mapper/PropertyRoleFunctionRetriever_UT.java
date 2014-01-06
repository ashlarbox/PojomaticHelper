package org.ashlarbox.pojomatic.mappings.mapper;

import org.ashlarbox.pojomatic.mappings.function.MapEqualsFieldFunction;
import org.ashlarbox.pojomatic.mappings.function.MapHashCodeFieldFunction;
import org.ashlarbox.pojomatic.mappings.function.MapToStringFieldFunction;
import org.junit.Test;
import org.pojomatic.internal.PropertyRole;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PropertyRoleFunctionRetriever_UT {

    private final PropertyRoleFunctionRetriever retriever = new PropertyRoleFunctionRetriever();

    @Test
    public void equalsRoleShouldReturnEqualsFunction() {
        assertThat(retriever.retrieve(PropertyRole.EQUALS), is(instanceOf(MapEqualsFieldFunction.class)));
    }

    @Test
    public void hashCodeRoleShouldReturnHashCodeFunction() {
        assertThat(retriever.retrieve(PropertyRole.HASH_CODE), is(instanceOf(MapHashCodeFieldFunction.class)));
    }

    @Test
    public void toStringRoleShouldReturnToStringFunction() {
        assertThat(retriever.retrieve(PropertyRole.TO_STRING), is(instanceOf(MapToStringFieldFunction.class)));
    }
}
