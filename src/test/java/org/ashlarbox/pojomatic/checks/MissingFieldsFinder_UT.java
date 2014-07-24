package org.ashlarbox.pojomatic.checks;

import org.junit.Test;

import java.util.List;
import java.util.Set;

import static com.google.common.collect.Sets.newHashSet;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MissingFieldsFinder_UT {

    private final MissingFieldsFinder missingFieldsFinder = new MissingFieldsFinder();

    @Test
    public void finderShouldOnlyReturnMissingFields() {
        String MATCHED_FIELD = randomAlphabetic(6);
        String MISSING_FIELD1 = randomAlphabetic(6);
        String MISSING_FIELD2 = randomAlphabetic(6);

        Set<String> expectedFields = newHashSet(MISSING_FIELD1, MATCHED_FIELD, MISSING_FIELD2);
        Set<String> actualFields = newHashSet(MATCHED_FIELD);

        List<String> missingFields = missingFieldsFinder.find(expectedFields, actualFields);

        assertThat(missingFields.size(), is(2));
        assertThat(missingFields, hasItems(MISSING_FIELD1, MISSING_FIELD2));
    }
}
