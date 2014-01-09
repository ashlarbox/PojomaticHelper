package org.ashlarbox.pojomatic.classproperties.function;

import org.junit.Test;
import org.pojomatic.internal.PropertyRole;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PropertyRoleFunctionRetriever_UT {

    private final PropertyRoleFunctionRetriever retriever = new PropertyRoleFunctionRetriever();

    @Test
    public void equalsRoleShouldReturnEqualsFunction() {
        assertThat(retriever.retrieve(PropertyRole.EQUALS), is(instanceOf(EqualsClassPropertiesFunction.class)));
    }

    @Test
    public void hashCodeRoleShouldReturnHashCodeFunction() {
        assertThat(retriever.retrieve(PropertyRole.HASH_CODE), is(instanceOf(HashCodeClassPropertiesFunction.class)));
    }

    @Test
    public void toStringRoleShouldReturnToStringFunction() {
        assertThat(retriever.retrieve(PropertyRole.TO_STRING), is(instanceOf(ToStringClassPropertiesFunction.class)));
    }
}
