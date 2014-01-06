package org.ashlarbox.pojomatic.mappings;

import org.junit.Before;
import org.junit.Test;

import static org.apache.commons.lang.RandomStringUtils.randomAlphabetic;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.assertThat;

public class PojomaticMappings_UT {

    private PojomaticMappings pojomaticMappings;

    @Before
    public void initializeTestObject() {
        pojomaticMappings = new PojomaticMappings();
    }

    @Test
    public void equalsTest() {
        String name = randomAlphabetic(6);
        pojomaticMappings.addEqualsField(name);
        assertThat(pojomaticMappings.getEqualsFields(), hasItem(name));
    }

    @Test
    public void hashCodeTest() {
        String name = randomAlphabetic(6);
        pojomaticMappings.addHashCodeField(name);
        assertThat(pojomaticMappings.getHashCodeFields(), hasItem(name));
    }

    @Test
    public void toStringTest() {
        String name = randomAlphabetic(6);
        pojomaticMappings.addToStringField(name);
        assertThat(pojomaticMappings.getToStringFields(), hasItem(name));
    }
}
