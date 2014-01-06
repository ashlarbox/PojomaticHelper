package org.ashlarbox.pojomatic.mappings;

import org.ashlarbox.pojomatic.PojomaticObject;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Iterator;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PojomaticMappingFieldsFinder_UT {

    private final PojomaticMappingFieldsFinder finder = new PojomaticMappingFieldsFinder();

    @Test
    public void finderShouldOnlyReturnExpectedField() {
        Iterable<Field> fields = finder.find(new TestObject());
        Iterator<Field> iterator = fields.iterator();
        assertThat(iterator.next().getName(), is("expectedField"));
        assertThat(iterator.hasNext(), is(false));
    }

    private class TestObject extends PojomaticObject {
        private String expectedField;
        private static final String UNEXPECTED = "ads";
    }
}
